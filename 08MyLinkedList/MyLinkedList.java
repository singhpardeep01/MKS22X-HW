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

    private LNode start;
    private int size;
    private LNode used;

    public boolean add( T value ) {
	if ( start == null ) {
	    start = new LNode(value);
	    used = start;
	}
	else {
	    used.setNext( new LNode(value) ); 
	    used = used.getNext();
	}
	size++;
	return true;
    }
    public boolean add ( int index, T value ) {
	if ( index == 0 ) {
	    LNode p = new LNode(value);
	    p.setNext(start);
	    start = p;
	    size++;
	    return true;
	}
	LNode current = start;
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
	LNode p = start;
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
	LNode current = start;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	return current.getValue();
    }
    
    public int indexOf( T value ) {
	LNode current = start;
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
    
    public T set( int index, T NewValue ) {
	LNode current = start;
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
