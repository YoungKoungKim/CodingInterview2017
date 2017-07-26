
public class Sum1to1000 {
	public static void main(String[] args) {
		int[] countArr = new int[10];
		for (int i = 1; i <= 1000; i++) {
			int num = i;
			while (num > 0) {
				countArr[num % 10]++;
				num = num / 10;
			}
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.println(j + " : " + countArr[j] + "개");
		}
	}
}
