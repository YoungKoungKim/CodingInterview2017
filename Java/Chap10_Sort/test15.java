package exercise;

import java.util.Scanner;

public class q15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.printf("정렬 할 행렬 입력 >> ");
		String arr = scan.nextLine();
		String strArr[] = arr.split(" ");
		int A[] = new int[strArr.length];
		int B[] = new int[A.length];

		for (int i = 0; i < strArr.length; i++) {
			A[i] = Integer.parseInt(strArr[i]);
		}

		CountingBinarySort(A, B, 2);

		System.out.print("정렬 된 행렬 >> ");
		for (int b : B) {
			System.out.printf(b + " ");
		}
		System.out.println();
	}

	static void CountingBinarySort(int[] A, int[] B, int K) {
		int[] C = new int[K + 1];

		for (int j = 0; j < A.length; j++) {
			C[A[j]] = C[A[j]] + 1;
		}

		System.out.println(C[0] + " " + C[1] + " " + C[2]);

		for (int i = 0; i < K+1; i++) {
			if (i == 0) {
				C[i]--;
			} else {
				C[i] = C[i] + C[i-1];
			}
		}
		
		System.out.println(C[0] + " " + C[1] + " " + C[2]);
		
		for (int k = A.length-1; k >= 0; k--) {
			B[C[A[k]]] = A[k];
			C[A[k]] = C[A[k]] - 1;
		}

	}
}
