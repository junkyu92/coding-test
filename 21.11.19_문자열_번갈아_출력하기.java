import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine();
		for (int i = 0; i < txt.length()/2; i++){
			System.out.print(txt.charAt(i));
			System.out.print(txt.charAt(txt.length()-1-i));
		}
		if(txt.length()%2!=0){
				System.out.print(txt.charAt(txt.length()/2));
			}
	}
}
