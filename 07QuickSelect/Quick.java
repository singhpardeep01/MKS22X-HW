import java.util.Arrays;
public class Quick{
    private static int partitionOld(int[]data, int left, int right) {
	int x = left + (int) (Math.random() * (right - left + 1));
	int y = data[x];
	int baser = right;
	data[x] = data[right];
	data[right] = y;
	right--;
        while (left != right) {
	    if ( data[left] > y ) {
		int temp = data[right];
		data[right] = data[left];
		data[left] = temp;
		right--;
	    }
	    else {
		left++;
	    }
	}
	if ( data[right] > y ) {
	    int temp = data[right];
	    data[right] = data[baser];
	    data[baser] = temp;
	    return right;
	}
	if (data[right] < y ) {
	    int temp = data[left+1];
	    data[left+1] = data[baser];
	    data[baser] = temp;
	    return left+1;
	}
	else {
	    return right;
	}
    }
    private static int[] partition(int[]data, int left, int right) {
	int x = left + (int) (Math.random() * (right - left + 1));
	int y = data[x];
	int baser = right;
	int[] ret = new int[2];
	data[x] = data[right];
	data[right] = y;
	right--;
        while (left != right) {
	    if ( data[left] > y ) {
		int temp = data[right];
		data[right] = data[left];
		data[left] = temp;
		right--;
	    }
	    else {
		left++;
	    }
	}
	int basel = left - 1;
	if ( data[right] > y ) {
	    int temp = data[right];
	    data[right] = data[baser];
	    data[baser] = temp;
	    ret[1] = right;
	}
	if (data[right] < y ) {
	    int temp = data[left+1];
	    data[left+1] = data[baser];
	    data[baser] = temp;
	    ret[1] = left+1;
	}
	else {
	    ret[1] = right;
	}
	for ( int i = 0; i < left; i++ ) {
	    if ( data[i] == y ) {
		int temp = data[i];
		data[i] = data[left];
		data[left] = temp;
		left--;
	    }
	}
	ret[0] = left;
	return ret;
    }
    public static int quickselect(int[]data, int k) {
	return quickselect( data, k, 0, data.length-1 );
    }
    private static int quickselect(int[]data, int k, int left, int right) {
	if ( left == right ) {
	    return data[right];
	}
	int x = partitionOld(data,left,right);
	if ( k > x ) {
	    return quickselect( data,k,x+1,right );
	}
	else if( k < x ) {
	    return quickselect( data,k,left,x-1);
	}
	else {
	    return data[k];
	}
    }
    public static void quickSortOld(int[] data) {
	quickSort(data,0,data.length-1);
    }
    private static void quickSortOld(int[]data, int left, int right) {
	if ( right - left >= 1) {
	int x = partitionOld(data,left,right);
	quickSort( data,x+1,right );
	quickSort( data,left,x-1);
	}
    }
    public static void quickSort(int[] data) {
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[]data, int left, int right) {
	if ( right - left >= 1) {
	int[] x = partition(data,left,right);
	quickSort( data,x[1]+1,right );
	quickSort( data,left,x[0]-1);
	}
    }
    public static String name(){
	return "7,Singh,Pardeep";
    }
    public static void main( String[] args ) {
	int[] d = new int [4000000];
	int[] c = new int [d.length];
	
	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	System.out.println("Working...");
	quickSortOld(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
	
    }
}
