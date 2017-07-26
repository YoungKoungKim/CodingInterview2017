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
			int size = A.length;
			Merge m = new Merge();
			m.mergeSort(A, 0, size-1);
		} else if (select == 6) {

		} else if (select == 7) {
			Quick q = new Quick();
			q.quickSort(A, 0, 7);
		} else if (select == 8) {
			int[] B = new int[A.length];
			
			int max = A[0];
			for (int num : A) {
				if (max < num)
					max = num;
			}
			System.out.println("max 값 : " + max);
			
			CountingSort(A, B, max);
			
			for (int i = 0; i < A.length; i++) {
				A[i] = B[i];
			}
		} else if (select == 9) {
			BucketSort(A);
		} else if (select == 0) {

		}

		System.out.print("\n정렬 된 행렬 >> ");
		for (int a : A) {
			System.out.printf(a + " ");
		}
		System.out.println();

	}

//	버블정렬
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

//	선택정렬
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

//	셸정렬
	static void ShellSort(int[] A) {
		int h = A.length / 2;
		int temp;
		int k;
		while (h >= 1) {
			for (int i = 0; i < h; i++) {
				// 부분 삽입 정렬 수행
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
	
//	계수정렬
	static void CountingSort(int A[], int B[], int K) {
		int[] C = new int[K + 1];

		for (int j = 0; j < A.length; j++) {
			C[A[j]] = C[A[j]] + 1;
		}

		for (int i = 0; i < K+1; i++) {
			if (i == 0) {
				C[i]--;
			} else {
				C[i] = C[i] + C[i-1];
			}
		}
		
		for (int k = A.length-1; k >= 0; k--) {
			B[C[A[k]]] = A[k];
			C[A[k]] = C[A[k]] - 1;
		}
		
	}
	
//	버킷정렬
	static void BucketSort(int A[]) {
		int max = A[0];
		for (int num : A) {
			if (max < num)
				max = num;
		}
		int BUCKETS = max+1;
		
		int i, j, k;
		int[] buckets = new int[BUCKETS];
		
		for (i = 0; i < A.length; i++)
			++buckets[A[i]];
		for (i = 0, j = 0; j < BUCKETS; j++)
			for (k = buckets[j]; k > 0; --k)
				A[i++] = j;
	}

}

// 병합정렬 클래스
class Merge {
	private int sorted[] = new int[30];
	private int cnt = 0;
	
	public void merge(int a[], int m, int middle, int n) {
		int size = a.length;
		int i, j, k, t;
		i = m;
		j = middle + 1;
		k = m;
		
		while (i <= middle && j <= n) {
			if (a[i] <= a[j])
				sorted[k] = a[i++];
			else
				sorted[k] = a[j++];
			k++;
		}
		
		if (i > middle) {
			for (t = j; t <= n; t++, k++)
				sorted[k] = a[t];
		} else {
			for (t = i; t <= middle; t++, k++)
				sorted[k] = a[t];
		}
		
		for (t = m; t <= n; t++)
			a[t] = sorted[t];
		
		System.out.printf(++cnt + "회차 >> ");
		for(t = 0; t < size; t++)
			System.out.printf("%3d", a[t]);
		System.out.println();
	}
	
	public void mergeSort(int a[], int m, int n) {
		int middle;
		if (m < n) {
			middle = (m+n) / 2;
			mergeSort(a, m, middle);
			mergeSort(a, middle+1, n);
			merge(a, m, middle, n);
		}
	}

}

// 퀵정렬 클래스
class Quick {
	int i = 0;

	public int partition(int a[], int begin, int end) {
		int pivot, temp, L, R, t;

		L = begin;
		R = end;
		pivot = (begin + end) / 2;
		System.out.printf("%d 단계 : pivot = %d\n", ++i, a[pivot]);

		while (L < R) {
			while ((a[L] < a[pivot]) && (L < R))
				L++;
			while ((a[R] >= a[pivot]) && (L < R))
				R--;
			if (L < R) {
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;

				if (L == pivot) {
					for (t = 0; t < a.length; t++) {
						System.out.printf("%3d", a[t]);
					}
					System.out.println();

					return R;
				}
			}
		}

		temp = a[pivot];
		a[pivot] = a[R];
		a[R] = temp;
		for (t = 0; t < a.length; t++) {
			System.out.printf("%3d", a[t]);
		}
		System.out.println();
		return L;
	}

	public void quickSort(int a[], int begin, int end) {
		if (begin < end) {
			int p;
			p = partition(a, begin, end);
			quickSort(a, begin, p - 1);
			quickSort(a, p + 1, end);
		}
	}
}
