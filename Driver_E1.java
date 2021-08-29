
import java.util.NoSuchElementException;

public class Driver_E1<T> {

	public static class Element<T> {
		private final T genericValue;
		private Element<T> previousElement;
		private Element<T> nextElement;

		private Element(T value, Element<T> previousElement, Element<T> nextElement) {
			this.genericValue = value;
			this.previousElement = previousElement;
			this.nextElement = nextElement;
		}
	}

	private final Element<T> topLevel;
	private int size;

	public Driver_E1() {
		topLevel = new Element<T>(null, null, null);
		topLevel.nextElement = topLevel;
		topLevel.previousElement = topLevel;
		size = 0;
	}

	// Returns the size of the list.

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return topLevel == null;
	}

	public T first() {
		if (topLevel == null)
			return null;
		return topLevel.genericValue;
	}

	private void addAfter(Element<T> before, T object) {
		Element<T> after = before.nextElement;
		before.nextElement = new Element<T>(object, before, after);
		after.previousElement = before.nextElement;
		size++;
	}

	public void addFirst(T object) {
		if (object == null) {
			throw new NullPointerException();
		}

		addAfter(topLevel, object);

	}

	public void enqueue(T object) {

		if (object == null) {
			throw new NullPointerException();
		}

		addAfter(topLevel.previousElement, object);
	}

	private void remove(Element<T> current) {
		Element<T> before = current.previousElement, after = current.nextElement;
		before.nextElement = after;
		after.previousElement = before;
		size--;
	}

	public void dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		remove(topLevel.nextElement);
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("{");
		Element<T> elementValue = topLevel.nextElement;
		while (elementValue != topLevel) {
			stringBuffer.append(elementValue.genericValue);
			if (elementValue.nextElement != topLevel) {
				stringBuffer.append(",");
			}
			elementValue = elementValue.nextElement;
		}
		stringBuffer.append("}");
		return stringBuffer.toString();
	}

	public static void main(String args[]) {
		Driver_E1<Integer> driverLinkedQueue = new Driver_E1<Integer>();
		driverLinkedQueue.enqueue(1);
		driverLinkedQueue.enqueue(7);
		driverLinkedQueue.enqueue(3);
		driverLinkedQueue.enqueue(4);
		driverLinkedQueue.enqueue(9);
		driverLinkedQueue.enqueue(2);

		System.out.println("Queued elements");
		System.out.println(driverLinkedQueue.toString());
		driverLinkedQueue.dequeue();
		System.out.println("removing first element:");
		System.out.println(driverLinkedQueue.toString());

	}
}
