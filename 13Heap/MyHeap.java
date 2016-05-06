import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap() {
       size = 0;
       data = (T) new Comparable[10];
   }
   public MyHeap(T[] array) {
       size = array.length-1;
       data = (T) new Comparable[size+1];
       for (T x : array) {
	   add(x);
       }
       heapify();
   }
   private void pushDown(int k) {
       if (k == size || k*2 > data.length-2) {
       }
       else if( data[k].compareTo(data[k*2]) < 0) {
	       T temp = data[k];
	       data[k] = data[k*2];
	       data[k*2] = temp;
       }
       else 
   }
   private void pushUp(int k) {
   }
   private void heapify() {
   }
   public T delete() {
       T = data[1];
       for (int x = 1; x < size+1; x--) {
	   data[x] = data[x+1];
       }
       data[size] = null;
       return T;
   }
   public void add(T x) {
       if (size == data.length-1) {
	   doubleSize();
       }
       if (size == 0) {
	   data[0] = x;
       }
       else {
	   data[size+1] = x;
       }
       size++; 
   }
   private void doubleSize() {
       T[] temp = new (T) Comparable[size*2];
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
       return retStr.substring(0,retStr.length()-1);
   }

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
