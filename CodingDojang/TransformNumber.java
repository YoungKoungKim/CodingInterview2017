import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
위 그림을 참조하여 라이브러리를 사용하지 말고 10진수를 n진수로 변환하는 프로그램을 작성하시오.. (단, n의 범위는 2 <= n <= 16)

예)
•2진수로 변환 : 233(10) --> 11101001(2)
•8진수로 변환 : 233(10) --> 351(8)
•16진수로 변환 : 233(10) --> E9(16)
 */

public class TransformNumber {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.printf("변환할 수 입력 >> ");
		int number = scan.nextInt();
		System.out.printf("진수 입력 >> ");
		int N = scan.nextInt();
		if (N < 2 || N > 16) {
			System.out.println("N은 2이상 16이하의 수로 입력하세요.");
		} else {
			while (number > 0) {
				list.add(number % N);
				number = number / N;
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			int tmp = list.get(i);
			if (tmp >= 10) {
				tmp = 55 + tmp;
				System.out.printf("%c", tmp);
			} else {
				System.out.print(tmp+"");
			}
		}
		System.out.println("(" + N + ")");
	}
}
