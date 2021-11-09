def aa(in1):
	for i in range(in1):
		in2 = int(input())
		if in2 == 0 :
			in3 = int(input())
			if len(a)<10:
				a.append(in3)
			else:
				print("overflow")
		elif in2 == 1 :
			if len(a) == 0:
				print("underflow")
			else:
				a.pop(len(a)-1)
		else:
			break
	for i in a:
		print(i, end=" ")
	
in1 = int(input())
a = []
aa(in1)
