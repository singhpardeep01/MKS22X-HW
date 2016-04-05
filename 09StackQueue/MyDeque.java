import java.util.*;
public class MyDeque<T> {
    T[] data;
    int size,first,last;

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public MyDeque(){
	//typecast object array to generic array
	data = (T[]) new Object[10];
    }
    
    private void resize() {
	T[] temp = (T[]) new Object[size*2];
	int i = first;
	for (int t = 0; t < size; t++) {
	    temp[t] = data[i%size];
	    if (i == last) {
		i = first;
	    }
	    else if (i == data.length - 1) {
		i = 0;
	    }
	    else {
		i++;
	    }
	}
	data = temp;
	first = 0;
	last = size - 1;
	for (int t = 0; t < size; t++) {
	    System.out.println( data[t] );
	}
    }

    public void addFirst(T value) {
	if (size == data.length) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	    first = 0;
	    last = 0;
	}
	else if (first == 0) {
	    data[data.length - 1] = value;
	    first = data.length - 1;
	}else {
	    data[first - 1] = value;
	    first--;
	}
	size++;
    }
    
    public void addLast(T value) {
	if (size == data.length) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	    first = 0;
	    last = 0;
	}
	else if (last == data.length - 1) {
	    data[0] = value;
	    last = 0;
	}else {
	    data[last + 1] = value;
	    last++;
	}
	size++;
    }

    public T removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T temp = data[first];
	if (first == data.length - 1) {
	    data[data.length - 1] = null;
	    first = 0;
	}else {
	    data[first] = null;
	    first++;
	}
	size--;
	return temp;
    }
    
    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T temp = data[last];
	if (last == 0) {
	    data[0] = null;
	    last = data.length - 1;
	}else {
	    data[last] = null;
	    last--;
	}
	size--;
	return temp;
    }

    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[last];
    }
    public String toString() {
	String retStr = "[" + data[0];
	for (int i = 1; i < size; i++) {
	    retStr += ", " + data[i];
	    
	}
	return retStr + "]";
    }
    
    public static void main(String[]args){
	MyDeque<Integer> n = new MyDeque<>();
	for (int i = 0; i < 10; i++) {
	    n.addLast(i);
	}
	System.out.println(n);
	for (int i = 0; i < 10; i++) {
	    n.addFirst(i);
	}	
	System.out.println(n);
	n.removeLast();
	n.addFirst(100);
	System.out.println(n);
	n.removeFirst();
	n.removeFirst();
	n.addLast(111);
	n.addFirst(132);
	System.out.println(n);
    }
}
