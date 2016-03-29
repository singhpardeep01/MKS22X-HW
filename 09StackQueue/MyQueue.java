
import java.util.NoSuchElementException;
public class MyQueue<T> {
    private MyLinkedList<T> queue;
    public MyQueue() {
	queue = new MyLinkedList<>();
    }
    public void enqueue(T item) {
	queue.add(item);
    }
    public T dequeue() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }
    public T peek() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return queue.get(0);
    }
    public int size() {
	return queue.size();
    }
    public boolean isEmpty() {
	return size() == 0;
    }
}
