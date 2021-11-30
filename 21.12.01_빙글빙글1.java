import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean[][] arr = new boolean[num][num];
		for(int i = 0; i < num; i++){
			if(i==0){
				Arrays.fill(arr[0], true);
			}else if(i%4==1){
				for(int j = (i/2)+1; j <= num-(i/2+1); j++ ){
					arr[j][num-(i/2+1)] = true;
				}
			}else if(i%4==2){
				for(int j = i/2-1; j <= num-(i/2-1)-2; j++ ){
					arr[num-(i/2-1)-1][j] = true;
				}
			}else if(i%4==3){
				for(int j = i/2+1; j <= num-(i/2+1)+1; j++ ){
					arr[j][i/2-1] = true;
				}
			}else if(i%4==0){ //1~8 3~6
				for(int j = i/2-1; j <= num-(i/2+1); j++ ){
					arr[i/2][j] = true;
				}
			}
		}
		
		for(int i = 0; i < num; i++){
			for(int j = 0; j < num; j++){
				if(arr[i][j]==true){
					System.out.print("# ");
				}else{
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
	}
}
