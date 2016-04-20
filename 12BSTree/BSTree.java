public class BSTree<T extends Comparable<T>> {
    private class Node{
	T data;
	Node left, right;
	int height;
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
	    return height;
	}
	public void add(T value){
	}
	public String toString(){
	}
	public boolean contains(T value){
	}
    }
