from numpy import *
import numpy as np
import string
import sys
#set basic params
time_predict = 20
input_layers_num = 1
hidden_layers_num = 5
output_layers_num = 1
X = []
y = []
loop = 0

#init sample from file

temp = 0.0
index = 0.0
path = 'data/' + str(sys.argv[1])
for line in open(path):
    s = line.strip().split()
    if s:
        loop += 1
        temp += string.atof(s[0])
        index += string.atof(s[1])
        X.append(np.array([temp]))
        y.append(index)

#  get output_weights matrix

X = np.array(X)
y = np.array(y)
y = np.array([y]).T
input_weights = 2 * np.random.random((input_layers_num, hidden_layers_num)) - 1
hidden = X.dot(input_weights)
output_weights = (mat(hidden)).I.dot(y)
# sample = np.zeros((loop,1))
# for i in range(len(X)):
#     if i==0:
#         sample[0][0] = X[loop-1][0]+loop
#     else:
#         sample[i][0] = sample[i-1][0]+loop
#     loop +=1
predicts = []
temp = np.random.random((loop+time_predict,1))
for i in range(loop):
    temp[i][0] = X[i][0]
for i in range(time_predict):
    temp[loop+i][0] = temp[loop-1+i] + loop + i + 1
result = temp.dot(input_weights).dot(output_weights)
with open('data/ELM.txt', 'w') as file:
    s = '\t\r'.join(str(i[0]) for i in (np.array(result)))
    file.write(s)
    file.close()


