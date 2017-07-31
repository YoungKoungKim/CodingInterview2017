/*
주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.


이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌
1.김씨와 이씨는 각각 몇 명 인가요?
2."이재영"이란 이름이 몇 번 반복되나요?
3.중복을 제거한 이름을 출력하세요.
4.중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.

*/

package test2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SinapSoft {
	public static void main(String[] args) {
		String str = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
		String[] strArr = str.split(",");
		List<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		List<String> sortedList = new ArrayList<>();
		
		for (String s : strArr) {
			list.add(s);
		}
		
		int kim = 0;
		int lee = 0;
		int leejayoung = 0;
		for (String s : list) {
			if (s.substring(0, 1).equals("김")) {
				kim++;
			} else if (s.substring(0, 1).equals("이")) {
				lee++;
			}
			
			if (s.equals("이재영"))
				leejayoung++;
		}
		System.out.println("1 >> 김 : " + kim + "번, 이 : " + lee + "번");
		System.out.println("2 >> 이재영 : " + leejayoung + "번");
		
		set.addAll(list);
		System.out.printf("3 >> ");
		for (String s : set) {
			System.out.printf(s + ", ");
		}
		System.out.println();
		
		sortedList.addAll(set);
		sortedList.sort(null);
		System.out.printf("4 >> ");
		for (String s : sortedList) {
			System.out.printf(s + ", ");
		}
	}
}
