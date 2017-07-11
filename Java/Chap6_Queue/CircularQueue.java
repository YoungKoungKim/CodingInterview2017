package basic;

import java.util.Scanner;

interface ICircularQueue {
	boolean isEmptyQueue();
	boolean isFullQueue();
	void enQueue(int data);
	int deQueue();
	void deleteQueue(CircularQueue queue);
	void printQueue();
}

public class CircularQueue implements ICircularQueue {
	private int front;
	private int rear;
	private int size;
	private int data[];

	public CircularQueue(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		data = new int[this.size];
	}

	@Override
	public boolean isEmptyQueue() {
		return (front == rear);
	}

	@Override
	public boolean isFullQueue() {
		// rear의 다음 위치가 front라면 삽입 불가
		return (((rear + 1) % this.size) == front);
	}

	@Override
	public void enQueue(int data) {
		if (isFullQueue()) {
			System.out.println("Queue is full");
		} else {
			rear = (rear + 1) % this.size;
			this.data[rear] = data;
			System.out.println("insert : " + data);
		}
	}

	@Override
	public int deQueue() {
		if (isEmptyQueue()) {
			System.out.println("Queue is empty");
			return 0;
		} else {
			front = (front + 1) % this.size;
			return this.data[front];
		}
	}

	@Override
	public void deleteQueue(CircularQueue queue) {
		if (!(queue == null))
			queue = null;
	}
	
	@Override
	public void printQueue() {
		if (isEmptyQueue()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = (front + 1) % this.size; i != (rear + 1) % this.size; i = ++i % this.size) {
				System.out.printf(this.data[i] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CircularQueue queue = null;
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
				queue = new CircularQueue(size);
				System.out.println("Create Queue Complete");
			} else if (select == 2) {
				System.out.printf("input data >> ");
				int data = scan.nextInt();
				queue.enQueue(data);
			} else if (select == 3) {
				System.out.println(queue.deQueue());
			} else if (select == 4) {
				try {
					queue.deleteQueue(queue);
					System.out.println("Delete Queue Complete");
				} catch (NullPointerException e) {
					System.out.println("Queue is null");
				}
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
