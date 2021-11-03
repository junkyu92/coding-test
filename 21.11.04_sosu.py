import math
def sosu (in1):
	result = "True"
	i = 2
	while math.sqrt(in1) >= i:
		if(in1 % i == 0):
			result = "False"
			break
		i += 1
	print(result)
	
in1 = int(input())
sosu(in1)
