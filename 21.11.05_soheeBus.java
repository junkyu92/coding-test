import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] n = sc.nextLine().split(" ");
		int busNum = 0;
		int a = 99999999;
		for (int i = 0; i < Integer.parseInt(n[0]); i++){
			String[] n2 = sc.nextLine().split(" ");
			int j = 0;
			while(Integer.parseInt(n2[0]) + Integer.parseInt(n2[1])*j - Integer.parseInt(n[1]) < a && a != 0){
					if(Integer.parseInt(n2[0]) + Integer.parseInt(n2[1])*j - Integer.parseInt(n[1]) >= 0){
						a = Integer.parseInt(n2[0]) + Integer.parseInt(n2[1])*j - Integer.parseInt(n[1]);
						busNum = i + 1;
					}
				j++;
			}
		}
		System.out.print(busNum);
	}
}
