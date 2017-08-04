package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		char[] charArr = str.toCharArray();
		List<Character> stack = new ArrayList<>();
		List<Character> result = new ArrayList<>();

		for (char c : charArr) {
			if (c >= 'A' && c <= 'Z') {
				result.add(c);
			/*} else if (c == ']') {
				while (true) {
					if (stack.get(stack.size() - 1) == '[') {
						break;
					} else {
						result.add(stack.get(stack.size() - 1));
						stack.remove(stack.size() - 1);
					}
				}
			} else if (c == '}') {
				while (true) {
					if (stack.get(stack.size() - 1) == '{') {
						break;
					} else {
						result.add(stack.get(stack.size() - 1));
						stack.remove(stack.size() - 1);
					}
				}*/
			} else if (c == ')') {
				while (true) {
					char tmp = stack.get(stack.size()-1);
					if (tmp != '(') {
						result.add(tmp);
						stack.remove(stack.size()-1);
					} else {
						stack.remove(stack.size()-1);
						break;
					}
				}
			} else if (c == '-' || c == '+') {
				while (true) {
					if (stack.isEmpty()) {
						break;
					} else {
						char tmp = stack.get(stack.size()-1);
						if (tmp == '(') {
							break;
						} else {
							result.add(tmp);
							stack.remove(stack.size()-1);
						}
					}
				}
				stack.add(c);
			} else {
				stack.add(c);
			}

			System.out.println(c);
			System.out.println(result);
			System.out.println(stack);
			
			System.out.println();
		}

		while (!stack.isEmpty()) {
			result.add(stack.get(stack.size() - 1));
			stack.remove(stack.size() - 1);
		}

		System.out.println(result);

	}
}
