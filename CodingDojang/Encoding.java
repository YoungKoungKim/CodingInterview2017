import java.util.Scanner;
/*
 * 7. 인터페이스를 만들어라
인터페이스명 : EncodingMessage
메소드명 : encode (String 리턴, 파라미터 String message)

8. 7번의 인터페이스를 implements 하는 클래스를 만들어라.
클래스는 생성자로 int n을 받는다. encode 메소드를 오버라이딩 하는데, message를 n번 섞는 메소드이다. 한 번 할 때 message의 반을 나누어 섞는다.
ex ) message 가 “abcdefgh”라면, “abcd”, “efgh”로 나뉜다. 이 두가지를 하나씩 가지고 와서 섞으면 “aebfcgdh” 이 된다. 이 작업을 n번 한다.

 */

public class Encoding {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("변환할 문자열 입력 >> ");
		String str = scan.next();
		System.out.printf("변환할 횟수 입력 >> ");
		int n = scan.nextInt();

		// n번
		for (int i = 0; i < n; i++) {
			str = encode(str);
		}
		
		System.out.println(str);
		
	}

	public static String encode(String message) {
		int size = message.length();
		int mid = size / 2;
		char[] tmp1 = new char[size - mid];
		char[] tmp2 = new char[mid];
		char[] resultStr = new char[size];
		String result = "";

		for (int i = 0; i < size; i++) {
			if (i < (size - mid)) {
				tmp1[i] = message.charAt(i);
			} else {
				tmp2[i - mid] = message.charAt(i);
			}
		}

		for (int j = 0; j < size; j++) {
			if (j % 2 == 0) {
				resultStr[j] = tmp1[j / 2];
			} else {
				resultStr[j] = tmp2[j / 2];
			}
		}

		for (char c : resultStr) {
			result = result + Character.toString(c);
		}

		return result;
	}
}
