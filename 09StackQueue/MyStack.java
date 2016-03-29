import java.util.NoSuchElementException;
public class MyStack<T> {
    private MyLinkedList stack = new MyLinkedList();
    public void push(T item) {
	stack.add(0,item);
    }
    public T pop() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	T item = (T) stack.get(0);
	stack.remove(0);
	return item;
    }
    public T peek() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return (T) stack.get(0);
    }
    public int size() {
	return stack.size();
    }
    public boolean isEmpty() {
	return size() > 0;
    }
}
