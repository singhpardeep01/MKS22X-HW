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
	   add(array[x]);
       }
       heapify();
   }
   private void pushDown(int k) {
   }
   private void pushUp(int k) {
   }
   private void heapify() {
   }
   public T delete() {
       return data[0];   
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
   }

   //do this last
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)

}
