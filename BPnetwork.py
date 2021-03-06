#coding:utf-8
import  string
import sys
import numpy as np
import sklearn.datasets
import math

epsilion = 0.01
reg_lambda = 0.01
np.random.seed(0)
time_predict = 20

input_layers = 1
hidden_layers = 5
output_layers = 1
X = []
y = []
loop = 0
temp = 0.0
index = 0.0
path = 'data/'+str(sys.argv[1])
for line in open(path):
    s = line.strip().split()
    if s :
        loop+=1
        temp += string.atof(s[0])
        index += string.atof(s[1])
        X.append(np.array([temp]))
        y.append(index)
X = np.array(X)
y = np.array(y)
sample_num = loop
X_max = X[loop-1][0]
X_min = X[0][0]
y_max = y[loop-1]
y_min = y[0]

# y =np.array([y]).T
def net_init():
    # sample, result = sklearn.datasets.make_moons(sample_num, noise=0.20)
    sample = (X-X_min)/(X_max-X_min)
    result = (y-y_min)/(y_max-y_min)
    W1 = 2 * np.random.random(( hidden_layers,input_layers)) - 1
    W2 = 2 * np.random.random((output_layers,hidden_layers)) - 1
    b1 = np.zeros((hidden_layers,1))
    b2 = np.zeros((output_layers,1))
    net = {'sample':sample,'result':result,'W1':W1,'W2':W2,'b1':b1,'b2':b2}
    return net

def train(net,loops=20000):
    sample,result,W1,W2,b1,b2 = net['sample'],net['result'],net['W1'],net['W2'],net['b1'],net['b2']
    axis = []
    for i in range(loops):
        z2 = W1.dot(sample.T)+b1
        a2 = np.tanh(z2)
        z3  = W2.dot(a2)+b2
        exp_scores = np.exp(z3)

        delta3 = exp_scores - result
        # delta3[result,range(sample_num)]-=1
        # print delta3[result,range(sample_num)]-2
        dW2 = delta3.dot(a2.T)
        db2 = np.sum(delta3,axis=1,keepdims=True)
        delta2 = W2.T.dot(delta3)*(1-np.power(a2,2))
        dW1 = delta2.dot(sample)
        db1 = np.sum(delta2,axis=1,keepdims=True)

        dW2 += reg_lambda*W2
        dW1 += reg_lambda*W1

        W1 += -epsilion*dW1
        W2 += -epsilion*dW2
        b1 += -epsilion*db1
        b2 += -epsilion*db2
        net = {'sample': sample, 'result': result, 'W1': W1, 'W2': W2, 'b1': b1, 'b2': b2}

    return net
def predict(net):
    sample,result,W1,W2,b1,b2 =net['sample'],net['result'],net['W1'],net['W2'],net['b1'],net['b2']
    temp = np.random.random((loop+time_predict,1))
    for i in range(loop):
        temp[i][0] = X_max[i][0]
    for i in range(time_predict):
        temp[loop+i][0] =temp[loop-1+i] + loop + i + 1
    for i in range(loop+time_predict):
    z2 = W1.dot(temp.T)+b1
    a2 = np.tanh(z2)
    z3 = W2.dot(a2)+b2
    exp_scores = np.exp(z3)
    print exp_scores
    exp_scores = exp_scores*(y_max-y_min)+y_min
    print exp_scores
    with open('data/BPnetwork.txt', 'w') as file:
        # s = '\t\r'.join(str(i) for i in (y))
        # file.write(s)
        # file.write('\r')
        s = '\t\r'.join(str(i) for i in (np.array(exp_scores[0])))
        file.write(s)
        file.close()

net = net_init()
output = train(net)
predict(output)
