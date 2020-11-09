package arraytest;

import java.util.Scanner;

public class Cyclotron_matrix {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int range = scanner.nextInt();
		int number = 1;
		
		int[][] arr = new int[range][range];
		
		for(int i =0;i<range;i++) {
			for(int j = 0;j<range;j++) {
			}
		}
		
		for(int i = 0 ;i<arr.length;i++) {
			for(int j = 0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		
		
	}
}
