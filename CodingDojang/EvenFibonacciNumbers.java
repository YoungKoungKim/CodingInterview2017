/*
피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 

짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?

*/
public class EvenFibonacciNumbers {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		int num3;
		int sum = 0;
		
		while (num1 <= 4000000) {
			num3 = num1 + num2;
			if (num1 % 2 == 0) {
				sum += num1;
				System.out.printf(num1 + " ");
			}
			
			num1 = num2;
			num2 = num3;
		}
		System.out.println();
		System.out.println(sum);
	}
}
