txt = input()
txt2 = ""
for i in range(int(len(txt)/2)):
	txt2 += txt[i] + txt[-1-i]
if len(txt)%2 != 0:
	txt2 += txt[int((len(txt)-1)/2)]
print(txt2)
