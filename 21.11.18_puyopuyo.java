import java.io.*;
import java.util.*;
class Main {
	public static void puyo(String[] in1, String txt){
		int i = 0;
		if(Integer.parseInt(in1[0])==Integer.parseInt(in1[1])){
				System.out.print(txt);
		}else{
			while(i < txt.length()){
				int point = 1;
				if(i+point > txt.length()-1){
						break;
				}
				while(txt.charAt(i) == txt.charAt(i+point)){
					point++;
					if(i+point > txt.length()-1){
						break;
					}
				}
				if(point >= Integer.parseInt(in1[1])){
					txt = txt.substring(0,i) + txt.substring(i + point);
					i = -1;
				}
				i++;
			}
			if(txt.isEmpty()){
				System.out.print("CLEAR!");
			}else{
				System.out.print(txt);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] in1 = sc.nextLine().split(" ");
		String txt = sc.next();
		puyo(in1, txt);
	}
}
