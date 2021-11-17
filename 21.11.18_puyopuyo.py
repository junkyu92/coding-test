def puyo(n, m, txt):
	i = 0
	if n == m :
		print(txt)
	else:
		while i < len(txt):
			point = 1
			if i+point > len(txt)-1:
				break
			while txt[i] == txt[i+point]:
				point += 1
				if i+point > len(txt)-1:
					break
			if point >= m:
				txt = txt[:i] + txt[i+point:]
				i = -1
			i += 1
		if len(txt) == 0:
			print("CLEAR!")
		else:
			print(txt)

[n,m] = list(map(int,input().split(" ")))
txt = input()
puyo(n, m, txt)
