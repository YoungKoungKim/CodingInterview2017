package basic;

import java.util.Scanner;

//순차 자료구조 방식으로 큐 구현
public class ArrayQueue {
	private int front;
	private int rear;
	private int size;
	private int data[];
	
	public ArrayQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		data = new int[this.size];
	}
	
	public boolean isEmptyQueue() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return (rear == this.size - 1);
	}
	
	public void enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue if full");
		} else {
			this.data[++rear] = data;
			System.out.println("insert : " + data);
		}
	}
	
	public int deQueue() {
		if (isEmptyQueue()) {
			System.out.println("Queue is empty");
			return 0;
		} else {
			return this.data[++front];
		}
	}
	
	public void deleteQueue() {
		if (!(this.data == null))
			this.data = null;
	}
	
	public void printQueue() {
		if (isEmptyQueue()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = front + 1; i <= rear; i++) {
				System.out.print(this.data[i] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayQueue queue = null;
		int select = 0;
		
		while (true) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.create 2.enQueue 3.deQueue 4.delete 5.printQueue 6.exit");
			System.out.println("---------------------------------------------------------");
			System.out.printf("select menu >> ");
			select = scan.nextInt();
			System.out.println("");
			if (select == 1) {
				System.out.printf("input size >> ");
				int size = scan.nextInt();
				queue = new ArrayQueue(size);
				System.out.println("Create Queue Complete");
			} else if (select == 2) {
				System.out.printf("input data >> ");
				int data = scan.nextInt();
				queue.enQueue(data);
			} else if (select == 3) {
				System.out.println(queue.deQueue());
			} else if (select == 4) {
				queue.deleteQueue();
				System.out.println("Delete Queue Complete");
			} else if (select == 5) {
				System.out.println("Print Queue`");
				queue.printQueue();
			} else if (select == 6) {
				break;
			}
			System.out.println("");
		}
		
	}
}
