
public class Mul1to1000 {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i <= 1000; i++) {
			int num = i;
			int temp = 1;
			while (num > 0) {
				temp = temp * (num % 10);
				num = num / 10;
			}
			sum += temp;
		}
		
		System.out.println(sum);
	}
}
