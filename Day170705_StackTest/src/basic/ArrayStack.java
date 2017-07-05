package basic;

//배열 기반 구현
public class ArrayStack<T> {
	private T[] arr;
	private int top = 0;
	private static final int DEFAULT_STACK_SIZE = 3;
	
	public static void main(String[] args) {
		StackTest<Integer> intStack = new StackTest<Integer>(5);
		intStack.push(5);
		intStack.push(46);
		intStack.push(3);
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
	}
	
	public ArrayStack() {
		this(DEFAULT_STACK_SIZE);
	}
	
	public ArrayStack(int size) {
		arr = (T[])new Object[size];
	}
	
	public void push(T data) {
		if (arr.length == top) {
			System.out.println("stack is full");
		} else {
			arr[top++] = data;
		}
	}
	
	public T pop() {
		if (top == 0) {
			System.out.println("no data");
			throw new java.util.NoSuchElementException();
		} else {
			T data = arr[--top];
			arr[top] = null;
			return data;
		}
	}
	
}
