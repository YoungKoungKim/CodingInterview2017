package q4;

import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		String[] strArray = str.split(" ");
		int[] intArray = new int[strArray.length];
		
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		System.out.printf("input window size >> ");
		int windowSize = scan.nextInt();
		
		for (int i = 0; i <= intArray.length-windowSize; i++) {
			int max = intArray[i];
			System.out.printf("Window position : ");
			for (int j = i; j < i+windowSize; j++) {
				if (max < intArray[j])
					max = intArray[j];
				System.out.printf(intArray[j] + " ");
			}
			System.out.println("\nMax : " + max);
			System.out.println("");
		}
	}
}
