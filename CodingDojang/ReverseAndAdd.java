import java.util.Scanner;

public class ReverseAndAdd {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		// 0 < N <= 100
		if (N > 100 || N <= 0) {
			System.out.println("테스트케이스 N은 1부터 100 사이의 수입니다.");
		} else {
			for (int i = 0; i < N; i++) {
				int[] numArr = new int[N];
				numArr[i] = scan.nextInt();
				int reverseCnt = 0;

				while (true) {
					int reverseNum = reverseNumber(numArr[i]);
					if (numArr[i] == reverseNum) {
						System.out.println(reverseCnt + " " + reverseNum);
						break;
					} else {
						numArr[i] = numArr[i] + reverseNum;
						reverseCnt++;
						if (reverseCnt >= 1000) {
							System.out.println("1000회 안에는 회문을 찾을 수 없습니다.");
							break;
						}
					}
				}
			}
		}

	}

	public static int reverseNumber(int originNum) {
		int size = Integer.toString(originNum).length();
		int[] eachNum = new int[size];
		int reverseNum = 0;
		int cnt = 0;
		while (originNum > 0) {
			eachNum[cnt] = originNum % 10;
			originNum = originNum / 10;
			reverseNum = reverseNum * 10 + eachNum[cnt];
			cnt++;
		}

		return reverseNum;
	}
}
