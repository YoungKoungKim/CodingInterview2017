/*
숫자야구게임
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		int count = 0;
		Scanner scan = new Scanner(System.in);
		HashSet<Integer> number = new HashSet<>();
		
		while (number.size() < 3) {
			int random = (int)(Math.random() * 9);
			number.add(random);
		}
		
		ArrayList<Integer> randomNumberList = new ArrayList<>();
		randomNumberList.addAll(number);
		Collections.shuffle(randomNumberList);
		String randomNumber = "";
		for (int i : randomNumberList) {
			randomNumber += Integer.toString(i);
		}
		System.out.println(randomNumber);
		
		while (true) {
			int strike = 0;
			int ball = 0;
			System.out.printf("3자리 숫자를 입력하세요 >> ");
			String answer = scan.next();
			if (answer.length() != 3) {
				System.out.println("3자리 숫자만 입력해주세요.");
			} else {
				count++;
				if (answer.equals(randomNumber)) {
					System.out.println("정답입니다!");
					System.out.println("시도 회수 >> " + count);
					break;
				}
				
				char[] answerArr = answer.toCharArray();
				char[] randomArr = randomNumber.toCharArray();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (answerArr[j] == randomArr[i]) {
							if (i == j) {
								strike++;
							} else {
								ball++;
							}
						}
					}
				}
				System.out.println(strike + "S, " + ball + "B");
				System.out.println("시도 회수 >> " + count);
			}
		}
	}
}
