
n = list(map(int,input().split(" ")))
busNum = 0
a = 99999999
for i in range(n[0]):
	n2 = list(map(int,input().split(" ")))
	j = 0
	while n2[0] + n2[1]*j - n[1] < a and a != 0:
		if n2[0] + n2[1]*j - n[1] >= 0:
			a = n2[0] + n2[1]*j - n[1]
			busNum = i + 1			
		j += 1
print(busNum)
