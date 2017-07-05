package q8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test8 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		int length = str.length();
		List<Character> listStr = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			Character tmp = str.charAt(i);
			listStr.add(tmp);
		}
		
		int cnt = 0;
		for (int i = 0; i < length/2; i++) {
			if (listStr.get(i).equals(listStr.get(length-i-1))) {
				cnt++;
			}
			System.out.println(listStr.get(i) + ", " + listStr.get(length-i-1));
		}
		
		if (cnt == length/2)
			System.out.println("앞뒤가똑같음");
		else
			System.out.println("앞뒤가 다름");
	}

}
