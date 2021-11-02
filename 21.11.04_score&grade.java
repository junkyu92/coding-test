import java.io.*;
import java.util.*;
class Main {
	public static char grade(double result){
		char grade2 = 'F';
		if (result>=90){
			grade2 = 'A';
		}else if(result<90 && result>=80){
			grade2 = 'B';
		}else if(result<80 && result>=70){
			grade2 = 'C';
		}else if(result<70 && result>=60){
			grade2 = 'D';
		}
		return grade2;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		int sum = (Integer.parseInt(in[0]) + Integer.parseInt(in[1]) + Integer.parseInt(in[2]));
		double result = Math.round(sum / 3.0 * 100)/100.0;
		char grade2 = grade(result);
		System.out.printf("%.2f", result);
		System.out.print(" " + grade2);
		
	}
}
