class Node {
	int key;
	Node next;

	public Node(int key) {
		this.key = key;
		this.next = null;
	}
}

public class LinkedQueue_ex2 {
	Node frontValue, rearValue;
	public int size;

	public LinkedQueue_ex2() {
		this.frontValue = null;
		this.rearValue = null;
		this.size = 0;
	}

	void enqueue(int key) {
		Node node = new Node(key);

		if (this.rearValue == null) {
			this.frontValue = node;
			this.rearValue = node;
			this.size++;
			return;
		}
		System.out.println("LinkedQueue is " + key);
		this.rearValue.next = node;
		this.rearValue = node;
		this.size++;
	}

// Method to remove an key from queue.
	Node dequeue() {

		if (this.frontValue == null)
			throw new NullPointerException();

		Node node = this.frontValue;
		System.out.println("Dequeued item from LinkedQueue is " + this.frontValue.key);
		this.frontValue = this.frontValue.next;
		if (this.frontValue == null)
			this.rearValue = null;
		this.size--;
		return node;
	}

// Get Size
	public int getSize() {
		return this.size;
	}

	public void removeMiddle() {
		Node curr = frontValue;
		int length = 0;
		Node middle = frontValue;
		while (curr.next != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.next;
			}
			curr = curr.next;
		}
		if (length % 2 == 1) {
			middle = middle.next;
		}
		System.out.println("middle element of LinkedQueue : " + middle.key);
	}



}