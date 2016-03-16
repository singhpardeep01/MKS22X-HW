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

    public MyLinkedList( int length ) {
	start = new LNode(0);
	size = length;
	used = start;
	LNode current = start;
	while ( length > 0 ) {
	    current.setNext(new LNode(0));
	    current = current.getNext();
	    length--;
	}
    }
    public boolean add( int value ) {
	used.setValue(value);
	used = used.getNext();
	return true;
    }
    public String toString() {
	String retStr = "[";
	LNode current = start;
	retStr += current.getValue();
	int c = 1;   
	while ( size > c ) {
	    current = current.getNext();
	    retStr += ", " + current.getValue();
	    c++;
	}
	retStr += "]";
	return retStr;
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
	MyLinkedList x = new MyLinkedList(5);
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(4);
	x.add(5);
	System.out.println(x);
	System.out.println( x.get(0) );
	System.out.println( x.get(1) );
	System.out.println( x.get(2) );
	System.out.println( x.get(3) );
	System.out.println( x.get(4) );
	System.out.println( x.set(0,0) );
	System.out.println( x.set(1,1) );
	System.out.println( x.set(2,2) );
	System.out.println( x.set(3,3) );
	System.out.println( x.set(4,4) );
    }    
}
