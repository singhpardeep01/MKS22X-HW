public class Quick{
    private static int partition(int[]data, int left, int right) {
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
    public static int quickselect(int[]data, int k) {
	return quickselect( data, k, 0, data.length-1 );
    }
    private static int quickselect(int[]data, int k, int left, int right) {
	if ( left == right ) {
	    return data[right];
	}
	int x = partition(data,left,right);
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
    public static void quickSort(int[] data) {
	quickSort(data,0,data.length-1);
    }
    private static void quickSort(int[]data, int left, int right) {
	if ( right - left >= 1) {
	int x = partition(data,left,right);
	quickSort( data,x+1,right );
	quickSort( data,left,x-1);
	}
    }
    public static String name(){
	return "7,Singh,Pardeep";
    }
    public static void main( String[] args ) {	
    }
}
