

def grade(result):
	grade2 = 'F'
	if result>=90:
		grade2 = "A"
	elif 80<=result<90:
		grade2 = "B"
	elif 70<=result<80:
		grade2 = "C"
	elif 60<=result<70:
		grade2 = "D"
	return grade2	
	
in1 = list(map(int,input().split(" ")))
sum = in1[0] + in1[1] + in1[2]
result = round(sum/3, 2)
grade2 = grade(result)
print(f'{result:.2f}', grade2)
		
