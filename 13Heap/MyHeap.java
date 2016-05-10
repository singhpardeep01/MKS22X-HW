import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;

    public MyHeap() {
	size = 0;
	data = (T[]) new Comparable[10];
    }
    public MyHeap(T[] array) {
	size = array.length;
	data = (T[]) new Comparable[size+1];
	for (int x = 1; x < data.length; x++) {
	    data[x] = array[x-1];
	}
	heapify();
    }
    private void pushDown(int k) {
	while (k*2 <= size && k*2+1 <= size) {
	    //System.out.println(this);
	    //System.out.println( k + " " + k*2 + " " + k*2+1);
	    //System.out.println( data[k] + " " + data[k*2] + " " +data[k*2+1]);
	    if (data[k*2].compareTo(data[k]) > 0 || data[k*2+1].compareTo(data[k]) > 0) {
		if (data[k*2].compareTo(data[k*2+1]) > 0) {
		    T temp = data[k];
		    data[k] = data[k*2];
		    data[k*2] = temp;
		    k *= 2;
		}
		else {
		    T temp = data[k];
		    data[k] = data[k*2+1];
		    data[k*2+1] = temp;
		    k = k*2+1;
		}
	    }
	    else {
		break;
	    }
	}
	if (k*2 <= size && data[k*2].compareTo(data[k]) > 0) {
	    T temp = data[k];
	    data[k] = data[k*2];
	    data[k*2] = temp;
	    k *= 2;
	}
	else if (k*2+1 <= size && data[k*2+1].compareTo(data[k]) > 0) {
	    T temp = data[k];
	    data[k] = data[k*2+1];
	    data[k*2+1] = temp;
	    k = k*2+1 ;
	} 
    }
    private void pushUp(int k) {
	while (k > 1) {
	    //System.out.println( "lol" + k + " " + k/2);
	    //System.out.println( data[k] + " " + data[k/2]);
	    if (data[k].compareTo(data[k/2]) > 0) {
		T temp = data[k];
		data[k] = data[k/2];
		data[k/2] = temp;
		k = k/2;
	    }
	    else {
		break;
	    }
	}
    }
    private void heapify() {
	for (int x = size/2; x > 0; x--) {
	    pushDown(x);
	}
    }
    public T delete() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T temp = data[1];
	data[1] = data[size];
	data[size] = null;
	size--;
	pushDown(1);
	return temp;
    }
    public T peek() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return data[1];
    }
    public void add(T x) {
	if (size == data.length-1) {
	    doubleSize();
	}
	if (size == 0) {
	    data[1] = x;
	}
	else {
	    data[size+1] = x;
	    pushUp(size+1);
	}
	size++; 
    }
    private void doubleSize() {
	T[] temp = (T[]) new Comparable[size*2];
	for (int x = 1; x <= size; x++) {
	    temp[x] = data[x];
	}
	data = temp;   
    }
    public String toString() {
	String retStr = "";
	for (int x = 1; x < size+1; x++) {
	    retStr += data[x] + ", ";
	}
	return "[" + retStr.substring(0,retStr.length()-2) + "]";
    }

    //do this last
    public MyHeap(boolean isMax) {}
    public MyHeap(T[] array, boolean isMax) {}
    
    public static void main(String[] args) {
	MyHeap<Integer> a = new MyHeap<Integer>();
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	a.add(5);
	System.out.println(a);
	Integer[] b = new Integer[]{1,2,3,4,5};
	MyHeap<Integer> c = new MyHeap<Integer>(b);
	System.out.println(c);
	c.delete();
	c.add(6);
	System.out.println(c);	
    }	
}
