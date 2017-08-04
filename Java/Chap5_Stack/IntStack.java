//배열기반 구현
//사이즈 고정
import java.util.Scanner;

public class IntStack {
	private Integer[] arr;
	private int top = 0;
	private static final int DEFAULT_STACK_SIZE = 3;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = 0;
		IntStack intStack = null;
		while (true) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.Create stack 2.push 3.pop 4.Delete stack 5.Show 6.exit");
			System.out.println("----------------------------------------------------------");
			
			int select = scan.nextInt();
			if (select == 1) {
				System.out.print("input size > ");
				size = scan.nextInt();
				intStack = new IntStack(size);
			} else if (select == 2) {
				System.out.print("input data > ");
				int data = scan.nextInt();
				try {
					intStack.push(data);
				} catch (NullPointerException e) {
					System.out.println("no stack");
				}
			} else if (select == 3) {
				try {
					System.out.println(intStack.pop());
				} catch (NullPointerException e) {
					System.out.println("underflow");
				}
			} else if (select == 4) {
				
			} else if (select == 5) {
				for (Integer i : intStack.arr) {
					System.out.print(i + " ");
				}
				System.out.println("");
			} else if (select == 6) {
				break;
			}
		
		}
		
	}

	public IntStack() {
		this(DEFAULT_STACK_SIZE);
	}

	public IntStack (int size) {
		arr = new Integer[size];
	}

	public void push(int data) {
		if (arr.length == top) {
			System.out.println("stack is full");
		} else {
			arr[top++] = data;
		}
	}

	public int pop() {
		if (top == 0) {
			System.out.println("no data");
			throw new java.util.NoSuchElementException();
		} else {
			int data = arr[--top];
			arr[top] = (Integer) null;
			return data;
		}
	}
}
