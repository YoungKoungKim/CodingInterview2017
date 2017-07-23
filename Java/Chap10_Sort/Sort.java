package basic;

import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("정렬 할 행렬 입력 >> ");
		String arr = scan.nextLine();
		String strArr[] = arr.split(" ");
		int A[] = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			A[i] = Integer.parseInt(strArr[i]);
		}

		System.out.println();
		System.out.println("1.버블정렬 2.선택정렬 3.삽입정렬 4.셸정렬 5.병합정렬 6.힙정렬 7.퀵정렬 8.계수정렬 9.버킷정렬 0.기수정렬");
		System.out.printf("정렬 방식 선택 >> ");
		int select = scan.nextInt();

		if (select == 1) {
			BubbleSort(A);
		} else if (select == 2) {
			SelectionSort(A);
		} else if (select == 3) {
			InsertSort2(A);
		} else if (select == 4) {
			ShellSort(A);
		} else if (select == 5) {
			MergeSort(A, 0, A.length);
		} else if (select == 6) {

		} else if (select == 7) {

		} else if (select == 8) {

		} else if (select == 9) {

		} else if (select == 0) {

		}

		System.out.print("\n정렬 된 행렬 >> ");
		for (int a : A) {
			System.out.printf(a + " ");
		}
		System.out.println();

	}

	static void BubbleSort(int[] A) {
		int cnt = 0;
		boolean swapped = true;
		for (int pass = A.length - 1; pass >= 0 && swapped; pass--) {
			swapped = false;
			for (int i = 0; i <= pass - 1; i++) {
				if (A[i] > A[i + 1]) {
					// 요소를 치환함
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
					swapped = true;
				}
			}
			System.out.printf(++cnt + "회차 : ");
			for (int a : A) {
				System.out.printf(a + " ");
			}
			System.out.println();
		}
	}

	static void SelectionSort(int[] A) {
		int cnt = 0;
		int min;
		for (int i = 0; i < A.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[min] > A[j]) {
					min = j;
				}
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
			System.out.printf(++cnt + "회차 : ");
			for (int a : A) {
				System.out.printf(a + " ");
			}
			System.out.println();
		}
	}

	// 의식의 흐름대로 만든 삽입정렬
	static void InsertSort1(int[] A) {
		int j, v;
		int index;

		for (int i = 1; i < A.length; i++) {
			// 내 값
			v = A[i];
			// 내 원래 인덱스
			j = i;
			index = i;

			// for 문을 하나로 병합할 아이디어 찾아보기
			// 자리 찾기
			for (int r = j - 1; r >= 0; r--) {
				if (v < A[r])
					index = r;
			}

			// 뒤로 한칸씩 밀기
			for (int k = j; k > index; k--) {
				A[k] = A[k - 1];
			}

			// 나 끼워넣기
			A[index] = v;
		}
	}

	// 1보다 정리된 삽입정렬(책의 알고리즘을 따라감)
	static void InsertSort2(int[] A) {
		int temp;
		int j;
		int cnt = 0;
		for (int i = 1; i < A.length; i++) {
			temp = A[i];
			j = i;
			while ((j > 0) && (A[j - 1] > temp)) {
				A[j] = A[j - 1];
				j--;
			}
			A[j] = temp;
			System.out.printf(++cnt + "회차 : ");
			for (int a : A) {
				System.out.printf(a + " ");
			}
			System.out.println();
		}
	}

	static void ShellSort(int[] A) {
		int h = A.length / 2;
		int temp;
		int k;
		while (h >= 1) {
			for (int i = 0; i < h; i++) {
				// 부분 삽입 정렬 수행4
				for (int j = i + h; j < A.length; j = j + h) {
					temp = A[j];
					k = j - h;
					while ((k >= i) && (A[k] > temp)) {
						A[k + h] = A[k];
						k = k - h;
					}
					A[k + h] = temp;
				}
			}
			h = h / 2;
		}
	}
	
	static void MergeSort(int[] A, int left, int right) {
		int mid;
		if (left < right) {
			mid = (right + left) / 2;
			MergeSort(A, left, mid);
			MergeSort(A, mid+1, right);
			merge(A, left, mid, right);
		}
	}
	
	static void merge(int[] A, int left, int mid, int right) {
		int[] temp = new int[30];
		int i = left;
		int j = mid + 1;
		int k = left;
		int t;
		int cnt = 0;
		
		while (i <= mid && j <= right) {
			if (A[i] <= A[j])
				temp[k] = A[i++];
			else
				temp[k] = A[j++];
			k++;
		}
		
		if (i > mid) {
			for (t = j; t <= right; t++, k++)
				temp[k] = A[t];
		} else {
			for (t = i; i <= mid; t++, k++) {
				temp[k] = A[t];
			}
		}
		
		for (t = left; t <= right; t++) {
			A[t] = temp[t];
		}
		
		System.out.printf(++cnt + "회차 : ");
		for (int a : A) {
			System.out.printf(a + " ");
		}
		System.out.println();
 	}
}
