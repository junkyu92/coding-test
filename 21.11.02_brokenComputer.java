import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String in1 = sc.nextLine();
		String[] in11 = in1.split(" ");
		int first = Integer.parseInt(in11[0]);
		int second = Integer.parseInt(in11[1]);
		while(!(1<=first) || !(first<=Math.pow(10, 5)) || !(1<=second) || !(second<=Math.pow(10, 9))){
			in1 = sc.nextLine();
			in11 = in1.split(" ");
			first = Integer.parseInt(in11[0]);
			second = Integer.parseInt(in11[1]);
		}
		
		String in2 = sc.nextLine();
		String[] in22 = in2.split(" ");
		int[] in222 = new int[in22.length];
		for (int i = 0; i < in22.length; i++){
			in222[i] = Integer.parseInt(in22[i]);
			while(!(1<=in222[i]) || !(in222[i]<=Math.pow(10,9))){
				in2 = sc.nextLine();
				in22 = in2.split(" ");
				in222[i] = Integer.parseInt(in22[i]);
			}
		}
		int sum = 1;
		for(int i = first-1; i >= 1; i--){
			if(in222[i]-in222[i-1] <= second){
				sum++;
			}else{
				break;
			}
		}
		System.out.print(sum);
	}
}
