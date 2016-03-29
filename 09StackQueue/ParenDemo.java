public class ParenDemo {
    private static MyStack<String> stack;
    public ParenDemo() {
	stack = new MyStack<>();
    }
    public static boolean isMatching(String input) {
	for (int x = 0; x < input.length(); x++) {
	    System.out.println(  input.substring(x,x+1) );
	    if ( input.substring(x,x+1).equals("(") ||
		 input.substring(x,x+1).equals("[") ||
		 input.substring(x,x+1).equals("{") ||
		 input.substring(x,x+1).equals("<") ) {
		stack.push(input.substring(x,x+1));
	    }
	    else if ( input.substring(x,x+1).equals(")") ||
		      input.substring(x,x+1).equals("]") ||
		      input.substring(x,x+1).equals("}") ||
		      input.substring(x,x+1).equals(">") ) { 
		    if ( stack.isEmpty() ) {
			return false;
		    }
		    if ( !isClose(stack.pop(),input.substring(x,x+1)) ) {
			return false;
		    }
	    }
	}
	return true;
    }
    public static boolean isClose(String x, String y) {
	if ( ( x.equals("(") && y.equals(")") ) ||
	     ( x.equals("[") && y.equals("]") ) ||
	     ( x.equals("{") && y.equals("}") ) ||
	     ( x.equals("<") && y.equals(">") ) ) {
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
 
    }
}
