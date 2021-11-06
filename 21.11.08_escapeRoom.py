in1 = int(input())
in21 = set(map(int, input().split(" ")))
in3 = int(input())
in4 = list(map(int, input().split(" ")))
for i in in4:
	res = 0
	if i in in21:
		res = 1
	print(res)
