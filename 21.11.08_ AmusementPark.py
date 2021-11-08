def aa():
	in2 = list(map(int, input().split(" ")))
	in4 = []
	for i in range(in2[0]):
		in3 = list(map(int, input().split(" ")))
		in4.append(in3)
	sum = in2[0] * in2[1]
	for i in range(in2[0]-in2[1]+1):
		for j in range(in2[0]-in2[1]+1):
			num = 0
			for k in range(in2[1]):
				for l in range(in2[1]):
					if in4[i+k][j+l] == 1:
						num +=1
			if num < sum:
				sum = num
	print(sum)

	
in1 = int(input())
for i in range(in1):
	aa()
	
	
