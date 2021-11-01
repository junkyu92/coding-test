in11 = input().split(" ")
in22 = input().split(" ")

sum = 1
for i in range(int(in11[0])-1, 0, -1):
	if len(in22) > 1:
		if (int(in22[i]) - (int(in22[i-1]))) <= int(in11[1]):
			sum = sum + 1
		else:
			break
print(sum)
