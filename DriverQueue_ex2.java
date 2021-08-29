
public class DriverQueue_ex2 {

	public static void main(String[] args) {
		System.out.println(" Linked Queue ");
		LinkedQueue_ex2 linkedQueue = new LinkedQueue_ex2();

		linkedQueue.enqueue(10);
		linkedQueue.enqueue(20);
		linkedQueue.enqueue(30);
		linkedQueue.enqueue(40);
		linkedQueue.enqueue(50);
		linkedQueue.enqueue(60);
		linkedQueue.removeMiddle();
		linkedQueue.dequeue();
		linkedQueue.dequeue();
		
		linkedQueue.removeMiddle();
		linkedQueue.dequeue();
		linkedQueue.dequeue();
		System.out.println("Array Queue");
		Queue_ex2 queue = new Queue_ex2(4);
		queue.enqueue(10);
		queue.dequeue();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(50);
		queue.dequeue();


	}

}
