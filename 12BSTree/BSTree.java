public class BSTree<T extends Comparable<T>> {
    private class Node{
	T data;
	Node left, right;
	public void setData(T value){
	    data = value;
	}
	public T getData(){
	    return data;
	}
	public void setLeft(Node tree){
	    left = tree;
	}
	public Node getLeft(){
	    return left;
	}	
	public void setRight(Node tree){
	    right = tree;
	}
	public Node getRight(){
	    return right;
	}
	public int getHeight(){
	    return 0;
	}
	public void add(T value){
	    if (left == null) {
		left = value;
	    }
	    else if (right == null) {
		right = value;
	    }
	    else {
		int x = (int) (Math.random() * 2);
		if (x == 0) {
		    left.add(value);
		}
		else if (x == 1) {
		    right.add(value);
		}
	    }
	}
	public String toString(){
	}
	public boolean contains(T value){
	    if ( left.getData() == value || right.getData() == value) {
		return true;
	    }
	    if (! left == null) {
		return left.contains(value);
	    }
	    if (! right == null) {
		return right.contains(value);
	    }
	    return false;
	}
    }
