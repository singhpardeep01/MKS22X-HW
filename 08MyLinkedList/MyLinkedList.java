import java.util.*;
public class MyLinkedList<T> {
    private class LNode {
	private T value;
	private LNode next;
	public LNode( T val ) {
	    value = val;
	    next = null;
	}
	public T getValue() {
	    return value;
	}
	public void setValue( T val ) {
	    value = val;
	}
	public LNode getNext() {
	    return next; 
	}
	public void setNext( LNode x ) {
	    next = x;
	}
    }

    private LNode head;
    private int size;
    private LNode tail;

    public boolean add( T value ) {
	if ( head == null ) {
	    head = new LNode(value);
	    tail = head;
	}
	else {
	    tail.setNext( new LNode(value) ); 
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public boolean add ( int index, T value ) {
	if ( index > size || index < 0 ) {
	    throw new IndexOutofBoundsException();
	}
	else if ( index == 0 ) {
	    LNode p = new LNode(value);
	    p.setNext(head);
	    head = p;
	    size++;
	    return true;
	}
	else if ( index == size ) {
	    add(value);
	}
	LNode current = head;
	int c = 0;   
	while ( index-1 > c ) {
	    current = current.getNext();
	    c++;
	}
	LNode p = new LNode(value);
	p.setNext(current.getNext());
	current.setNext(p);
	size++;
	return true;
    }
    public String toString() {
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";
    }
    public int size() {
	return size;
    }
    
    public T get( int index ) {
	LNode current = head;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	return current.getValue();
    }
    
    public int indexOf( T value ) {
	LNode current = head;
	int c = 0;   
	while ( size > c ) {
	    if ( current.getValue().equals(value) ) {
		return c;
	    }
	    current = current.getNext();
	    c++;
	}
	return -1;
    }
    public T remove ( int index ) {
	if ( index >= size || index < 0 ) {
	    throw new IndexOutofBoundsException();
	}
	LNode current = head;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	T ret = current.getNext().getValue();
	current.setNext( current.getNext().getNext() );
    }
    
    public T set( int index, T NewValue ) {
	LNode current = head;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	T ret = current.getValue();
	current.setValue(NewValue);
	return ret;
    }
	
    public static void main( String[] args ) {
	MyLinkedList pardeep = new MyLinkedList<String>();
	pardeep.add("q");
	pardeep.add("w");
	pardeep.add("e");
	pardeep.add("r");
	pardeep.add("t");
	System.out.println(pardeep);
	pardeep.add(4,"y");
	pardeep.add(0,"u");
	System.out.println(pardeep);
	pardeep.set(0,"i");
	pardeep.set(1,"o");
	pardeep.set(2,"p");
	pardeep.set(3,"a");
	pardeep.set(4,"s");
	pardeep.set(5,"d");
	pardeep.set(6,"f");
	System.out.println(pardeep);
	System.out.println( pardeep.indexOf("i") );
	System.out.println( pardeep.get(0) );
	System.out.println( pardeep.get(1) );
	System.out.println( pardeep.get(2) );
	System.out.println( pardeep.get(3) );
	System.out.println( pardeep.get(4) );
	System.out.println( pardeep.get(5) );
    }    
}
