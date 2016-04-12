import java.util.*;

public class FrontierQueue<T> implements Frontier<T>{
    private Queue s = new Queue();
    public void add(T element) {
	s.add(element);
    }

    public T next() {
	s.remove();
    }
    
    public boolean hasNext() {
	if (s.peek == null) {
	    return false;
	}
	return true; 
    }
}
