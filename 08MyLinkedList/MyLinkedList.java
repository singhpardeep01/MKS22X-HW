public class MyLinkedList {
    private class LNode {
	private int value;
	private LNode next;
	public LNode( int val ) {
	    value = val;
	    next = null;
	}
	public int getValue() {
	    return value;
	}
	public void setValue( int val ) {
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

    public boolean add( int value ) {
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
    public boolean add ( int index, int value ) {
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
    
    public int get( int index ) {
	LNode current = start;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	return current.getValue();
    }
    
    public int indexOf( int value ) {
	LNode current = start;
	int c = 0;   
	while ( size > c ) {
	    if ( current.getValue() == value ) {
		return c;
	    }
	    current = current.getNext();
	    c++;
	}
	return -1;
    }
    
    public int set( int index, int NewValue ) {
	LNode current = start;
	int c = 0;   
	while ( index > c ) {
	    current = current.getNext();
	    c++;
	}
	int retInt = current.getValue();
	current.setValue(NewValue);
	return retInt;
    }
	
    public static void main( String[] args ) {
	MyLinkedList pardeep = new MyLinkedList();
	pardeep.add(0);
	pardeep.add(1);
	pardeep.add(2);
	pardeep.add(3);
	pardeep.add(5);
	System.out.println(pardeep);
	pardeep.add(4,4);
	pardeep.add(0,-1);
	System.out.println(pardeep);
	pardeep.set(0,1);
	pardeep.set(1,2);
	pardeep.set(2,3);
	pardeep.set(3,4);
	pardeep.set(4,5);
	pardeep.set(5,6);
	pardeep.set(6,7);
	System.out.println(pardeep);
	System.out.println( pardeep.indexOf(6) );
	System.out.println( pardeep.get(0) );
	System.out.println( pardeep.get(1) );
	System.out.println( pardeep.get(2) );
	System.out.println( pardeep.get(3) );
	System.out.println( pardeep.get(4) );
	System.out.println( pardeep.get(5) );
    }    
}
