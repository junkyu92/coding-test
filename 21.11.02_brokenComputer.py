# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math;
in1 = input()
in2 = input()
in11 = in1.split(" ")
in22 = in2.split(" ")

sum = 1
for i in range(int(in11[0])-1, 0, -1):
	if len(in22) > 1:
		if (int(in22[i]) - (int(in22[i-1]))) <= int(in11[1]):
			sum = sum + 1
		else:
			break
print(sum)
