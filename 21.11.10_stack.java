import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in1 = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < in1; i++){
			int in2 = sc.nextInt();
			if(in2==0){
				int in3 = sc.nextInt();
				if(a.size()<10){
					a.add(in3);
				}else{
					System.out.println("overflow");
				}
			}else if(in2 == 1){
				if(a.isEmpty()){
					System.out.println("underflow");
				}else{
					a.remove(a.size()-1);	
				}
			}else{
				break;
			}
		}
		for(int i : a){
			System.out.print(i + " ");
		}
	}
}
