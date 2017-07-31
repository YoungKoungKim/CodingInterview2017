/*
1~1000에서 각 숫자의 개수 구하기

예로 10 ~ 15 까지의 각 숫자의 개수를 구해보자 

10 = 1, 0
 11 = 1, 1
 12 = 1, 2
 13 = 1, 3
 14 = 1, 4
 15 = 1, 5 

그러므로 이 경우의 답은 0:1개, 1:7개, 2:1개, 3:1개, 4:1개, 5:1개

*/

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
