import java.util.NoSuchElementException;
public class MyQueue<T> {
    private MyLinkedList queue = new MyLinkedList();
    public void enqueue(T item) {
	queue.add(item);
    }
    public T dequeue() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	T item = (T) queue.get(0);
	queue.remove(0);
	return item;
    }
    public T peek() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return (T) queue.get(0);
    }
    public int size() {
	return queue.size();
    }
    public boolean isEmpty() {
	return size() > 0;
    }
}
