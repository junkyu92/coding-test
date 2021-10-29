# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
input = int(input())
for i in range(input-1, -1, -1):
	print(" "*i, end="")
	print("*"*(2*(input-i)-1), end="")
	print("")
