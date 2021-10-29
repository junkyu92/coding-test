# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math
in1 = int(input())
while not 1<=in1<=100:
	in1 = int(input())
in2 = input()
in3 = in2.split(" ")
in4 = {}
for i in range(len(in3)):
	in4[i] = int(in3[i])
	while not 1<=len(in4)<=in1 or not 100<=in4[i]<=math.pow(2, 31)-1:
		in2 = input()
sum = in1
result = ""
for i in range(len(in4)):
	result = result + str(i+1) + " "
	for j in range(32):
		if(in4[i] == math.pow(2, j)):
			sum = sum -1
			result = result.replace(str(i+1) + " ", "")
			
print(sum)
print(result)
