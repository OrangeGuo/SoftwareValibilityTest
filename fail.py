#coding:utf-8
import  string
import numpy as np
import math
import sys
X = []
y = []
loop = 0
index = 0.0
temp = 0.0
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
with open('data/fail.txt', 'w') as file:
    s = '\t\r'.join(str(i) for i in (y))
    file.write(s)
    file.close()