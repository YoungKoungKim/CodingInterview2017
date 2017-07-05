package q2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test2 {
	public static LinkedList<Character> list;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		int length = str.length();
		List<Character> listStr = new ArrayList<>();
		//리스트 입력
		for (int i = 0; i < length; i++) {
			listStr.add(str.charAt(i));
		}
		
		for (Character t : listStr) {
			if (t.equals(")")) {
				list.pop();
				System.out.println(t);
			} else if (t.equals("*")) {
				if (!list.isEmpty())
					list.pop();
			} else if (t.equals("(") || t.equals("+") || t.equals("-")) {
				if (!list.isEmpty())
					list.pop();
			}
		}
	}
}
