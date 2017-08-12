/*
2x2 Array곱셈
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Mod2x2 {
	public static void main(String[] args) {
		BufferedReader in;
		FileWriter out;
		String[][] arr1 = new String[2][2];
		String[][] arr2 = new String[2][2];
		
		int[][] numArr1 = new int[2][2];
		int[][] numArr2 = new int[2][2];
		
		int[][] result = new int[2][2];

		try {
			in = new BufferedReader(new FileReader("src/Mod2x2_input.txt"));
			out = new FileWriter("Mod2x2_output.txt");
			
			for (int i = 0; i < 2; i++) {
				arr1[i] = in.readLine().split(" ");
			}
			for (int i = 0; i < 2; i++) {
				arr2[i] = in.readLine().split(" ");
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					numArr1[i][j] = Integer.parseInt(arr1[i][j]);
					numArr2[i][j] = Integer.parseInt(arr2[i][j]);
				}
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					for (int k = 0; k < 2; k++) {
						result[i][j] += numArr1[i][k] * numArr2[k][j];
					}
				}
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
