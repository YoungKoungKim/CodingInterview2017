
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
