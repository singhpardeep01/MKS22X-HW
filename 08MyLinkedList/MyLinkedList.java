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

    public MyLinkedList( int length ) {
	start = null;
	size = 0;
	LNode current = start;
	while ( length > 0 ) {
	    current.setNext(LNode(0));
	    current = current.getNext();
	}
    }
    public boolean add( int value ) {
	if ( size == 0 ) {
	    start = new LNode(value);
	}
	else {
L
