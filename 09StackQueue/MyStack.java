import java.util.NoSuchElementException;
public class MyStack<T> {
    private MyLinkedList<T> stack;
    public MyStack() {
	stack = new MyLinkedList<>();
    }
    public void push(T item) {
	stack.add(0,item);
    }
    public T pop() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return stack.remove(0);
    }
    public T peek() {
	if ( isEmpty() ) {
	    throw new NoSuchElementException();
	}
	return stack.get(0);
    }
    public int size() {
	return stack.size();
    }
    public boolean isEmpty() {
	return size() == 0;
    }
    public static void main(String[]) {
	MyStack<Integers> stack = new MyStack<>();
	try{
	    stack.pop();
	}catch(NoSuchElementException e) {
	    System.out.println("pop is good.");
	}
	try{
	    stack.peak();
	}catch(NoSuchElementException e) {
	    System.out.println("peak is good.");
	}
	for(int x = 0; x < 10; x++) {
	    stack.push(x);
	}

}
