import java.util.*;

public class FrontierQueue<T> implements Frontier<T> {
    MyQueue<T> s = new MyQueue<T>();
    public void add(T element) {
	s.enqueue(element);
    }

    public T next() {
	return s.dequeue();
    }
    
    public boolean hasNext() {
	if (s.peek() == null) {
	    return false;
	}
	return true; 
    }
}
