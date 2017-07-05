package basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListStack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int select;
		List<Integer> arr = null;
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.create 2.push 3.pop 4.delete 5.show 6.exit");
			System.out.println("-----------------------------------------------");
			
			select = scan.nextInt();
			
			if (select == 1) {
				arr = new LinkedList<>();
				System.out.println("complete");
			} else if (select == 2) {
				int data;
				System.out.print("input data > ");
				data = scan.nextInt();
				
				arr.add(data);
			} else if (select == 3) {
				System.out.println(arr.get(arr.size()-1));
				arr.remove(arr.size()-1);
			} else if (select == 4) {
				arr = null;
			} else if (select == 5) {
				for (int i = 0; i < arr.size(); i++) {
					System.out.println(arr.get(i));
				}
			} else if (select == 6) {
				break;
			}
		}
		
	}
	
}
