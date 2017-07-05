package q2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test1 {
	private static List<Character> list;
	
	public static void main(String[] args) {
		list = new LinkedList<>();
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int length = str.length();
		List<Character> listStr = new ArrayList<>();
		//리스트 입력
		for (int i = 0; i < length; i++) {
			Character tmp = str.charAt(i);
			listStr.add(tmp);
		}
		
		boolean result = false;
		for (Character c : listStr) {
			if ((c=='(') || (c=='{') || (c=='[')) {
				list.add(c);
				System.out.println(list);
			} else if ((c==')') || (c=='}') || (c==']')) {
				if (list.isEmpty()) {
					System.out.println("스택이 비어 있습니다. 식 에러.");
					result = false;
				} else {
					Character popChar = list.get(list.size()-1);
					list.remove(list.size()-1);
					if (((popChar == '(') && (c == ')')) ||
							((popChar == '{') && (c == '}')) ||
								((popChar == '[') && (c == ']'))) {
						System.out.println(popChar + "," + c);
						System.out.println("매칭");
						result = true;
					} else {
						System.out.println(popChar + "," + c);
						System.out.println("매칭 에러");
						result = false;
						break;
					}
				}
			}
			System.out.println(list);
		}
		
		if (!(result && list.isEmpty())) {
			result = false;
		}
		System.out.println(result);
	}
	
	
}
