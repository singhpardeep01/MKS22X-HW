import java.util.*;

public class FrontierStack<T> implements Frontier<T>{
    private Stack s = new Stack();
    public void add(T element) {
	s.push(element);
    }

    public T next() {
	return (T) s.pop();
    }
    
    public boolean hasNext() {
	try {
	     s.peek();
	     return true;
	} catch (EmptyStackException e) {
	    return false;
	} 
    }
}
