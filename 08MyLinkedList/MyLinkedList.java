import java.util.*;
public class MyLinkedList<T> implements Iterable<T> {
    public Iterator<T> iterator() {
	return new MyIteratorThingyThatMakesLifeAlotEasier();
    }
    private class MyIteratorThingyThatMakesLifeAlotEasier implements Iterator<T> {
	private LNode next;
	public MyIteratorThingyThatMakesLifeAlotEasier() {
	    next = head;
	}
	public boolean hasNext() {
	    return next != null;
	}
	public T next() {
	    if ( hasNext() ) {
		T val = next.getValue();
		next = next.getNext();
		return val;
	    }
	    throw new NoSuchElementException();
	}
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }	
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
	}else{
	    tail.setNext( new LNode(value) ); 
	    tail = tail.getNext();
	}
	size++;
	return true;
    }
    public boolean add ( int index, T value ) {
	if ( index > size || index < 0 ) {
	    throw new IndexOutOfBoundsException();
	}
	else if ( index == 0 ) {
	    LNode p = new LNode(value);
	    p.setNext(head);
	    head = p;
	    size++;
	    return true;
	}
	else if ( index == size ) {
	    //System.out.println("testing");
	    tail.setNext( new LNode(value) );
	    //System.out.println(tail.getNext().getValue());
	    tail = tail.getNext();
	    size++;
	    //System.out.println(size);
	    //System.out.println(tail.getValue());
	    //System.out.println(this.toString());
	    return true;
	}
	else {
	    LNode current = head;
	    int c = 0;   
	    while ( index - 1 > c ) {
		current = current.getNext();
		c++;
	    }
	    LNode p = new LNode(value);
	    p.setNext(current.getNext());
	    current.setNext(p);
	    size++;
	    return true;
	}
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
	if ( index >= size || index < 0 ) {
	    throw new IndexOutOfBoundsException();
	}
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
	    throw new IndexOutOfBoundsException();
	}
	if ( index == 0 ) {
	    T ret = head.getValue();
	    head = head.getNext();
	    size--;
	    return ret;
	}
	if ( index == size -1 ) {
	    T ret = tail.getValue();
	    tail = head;
	    int c = 0;
	    while ( c != size - 2 ) {
		tail = tail.getNext();
		c++;
	    }
	    tail.setNext(null);
	    size--;
	    return ret;
	}
	    
	LNode current = head;
	int c = 0;   
	while ( index - 1 > c ) {
	    current = current.getNext();
	    c++;
	}
	T ret = current.getNext().getValue();
	current.setNext( current.getNext().getNext() );
	size--;
	return ret;
    }
    
    public T set( int index, T NewValue ) {
	if ( index >= size || index < 0 ) {
	    throw new IndexOutOfBoundsException();
	}
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
	MyLinkedList<Integer> pardeep = new MyLinkedList<>();
	for ( int i = 0; i < 10; i++ ) {
	    pardeep.add(i);
	}
	System.out.println(pardeep);
	for ( Integer x : pardeep ) {
	    System.out.print( x + " ");
	}
	System.out.println();
	/*
	pardeep.add("q");
	pardeep.add("w");
	pardeep.add("e");
	pardeep.add("r");
	pardeep.add("t");
	System.out.println(pardeep);
	pardeep.add(4,"y");
	System.out.println(pardeep);
	pardeep.set(0,"i");
	pardeep.set(1,"o");
	pardeep.set(2,"p");
	pardeep.set(3,"a");
	pardeep.set(4,"s");
	pardeep.set(5,"d");
	System.out.println(pardeep);
	pardeep.add(pardeep.size(),"u");
	System.out.println(pardeep);
	pardeep.add("z-end!");
	System.out.println(pardeep);
	System.out.println( pardeep.indexOf("i") );
	System.out.println( pardeep.get(0) );
	System.out.println( pardeep.get(1) );
	System.out.println( pardeep.get(2) );
	System.out.println( pardeep.get(3) );
	System.out.println( pardeep.get(4) );
	System.out.println( pardeep.get(5) );
	*/    
    }    
}
