import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		String result = "True";
		//2~n-1 까지 나눠지는경우 False 이건 아마도 시간복합도가 O(n)이지 않을까..
		//2~루트n 까지 나누면 O(루트n)이다.
		//2x8 8x2 이런식으로 했던 계산이 반복되기 때문에 루트n까지만 계산하면 뒤에는 중복계산임. 
		for (int i = 2; i <= Math.sqrt(in); i++){
			if (in % i == 0){
				result = "False";
		   break;
			}
		}
		System.out.print(result);
	}
}
