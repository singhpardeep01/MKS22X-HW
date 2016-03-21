import java.util.*;
public class Driver{
    public static void main(String[]args){
 MyLinkedList m = new MyLinkedList();
 ArrayList<Integer> n = new ArrayList<Integer>();

 long start,end;

 start = System.currentTimeMillis();
	n.add(0);
	n.add(1);
	n.add(2);
	n.add(3);
	n.add(5);
	System.out.println(n);
	n.add(4,4);
	n.add(0,-1);
	System.out.println(n);
	n.set(0,1);
	n.set(1,2);
	n.set(2,3);
	n.set(3,4);
	n.set(4,5);
	n.set(5,6);
	n.set(6,7);
	System.out.println(n);
	System.out.println( n.indexOf(6) );
	System.out.println( n.get(0) );
	System.out.println( n.get(1) );
	System.out.println( n.get(2) );
	System.out.println( n.get(3) );
	System.out.println( n.get(4) );
	System.out.println( n.get(5) );
        //code to test here on ArrayList n
 end = System.currentTimeMillis();
 System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");

 start = System.currentTimeMillis();
 	m.add(0);
	m.add(1);
	m.add(2);
	m.add(3);
	m.add(5);
	System.out.println(m);
	m.add(4,4);
	m.add(0,-1);
	System.out.println(m);
	m.set(0,1);
	m.set(1,2);
	m.set(2,3);
	m.set(3,4);
	m.set(4,5);
	m.set(5,6);
	m.set(6,7);
	System.out.println(m);
	System.out.println( m.indexOf(6) );
	System.out.println( m.get(0) );
	System.out.println( m.get(1) );
	System.out.println( m.get(2) );
	System.out.println( m.get(3) );
	System.out.println( m.get(4) );
	System.out.println( m.get(5) );
       //same code to test here on linked list m
 end = System.currentTimeMillis();
 System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");

    }
}
