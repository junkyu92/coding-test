//퀵정렬 후 이진검색

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int nx = sc.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			x[i] = sc.nextInt();
		}
		quickSort(x, 0, nx - 1);
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++){
			int m2 = sc.nextInt();
			if(Arrays.binarySearch(x, m2)<0){
				System.out.println(0);
				
			}else{
				System.out.println(1);
				
			}
		}
	}
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];
		
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if(pl <= pr) swap(a, pl++, pr--);
		} while (pl<=pr);

		if (left<pr) quickSort(a, left, pr);
		if (pl<right) quickSort(a, pl, right);
	}
}
