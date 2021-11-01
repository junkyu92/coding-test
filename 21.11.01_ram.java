import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String m = sc.nextLine();
		String[] m2 = m.split(" ");
		int[] m3 = new int[m2.length];
		int sum = n;
		String result = "";
		for (int i = 0; i < m2.length; i++){
			m3[i] = Integer.parseInt(m2[i]);
			boolean t = true;
			result = result + Integer.toString(i+1) + " ";
			for(int j =1; j<31; j++){
				if(m3[i]==Math.pow(2,j)){
					sum--;
					result = result.replace(Integer.toString(i+1) + " ", "");
					
				}	
			}
		}
		System.out.println(sum);
		System.out.println(result);
		
	}
}
