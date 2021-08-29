
public class Queue_ex2 {

	private int capacity;
	int arr[];
	int frontValue = 0;
	int rearValue = -1;
	int size = 0;

	public Queue_ex2(int size) {
		this.capacity = size;
		this.arr = new int[this.capacity];
	}

	
	public void enqueue(int element) {
		if (isFull()) {
			throw new IndexOutOfBoundsException();
		} else {
			rearValue++;
			if (rearValue == capacity - 1) {
				rearValue = 0;
			}

			arr[rearValue] = element;
			this.size++;
		}
		System.out.println("Enqueued item is " + arr[rearValue]);

		System.out.println("Queue Capacity:" + capacity + " Current Size:" + size);

	}

	
	public void dequeue() {
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			System.out.println("Dequeued item is " + arr[frontValue]);
			frontValue++;
			if (frontValue == capacity - 1)
				frontValue = 0;
			this.size--;
			System.out.println("Queue Capacity:" + capacity + " Current Size:" + size);
		}
	}

	
	public boolean isFull() {
		boolean status = false;
		if (size == capacity) {
			status = true;
		}
		return status;
	}

	
	public boolean isEmpty() {
		boolean status = false;
		if (size == 0) {
			status = true;
		}
		return status;
	}

}
