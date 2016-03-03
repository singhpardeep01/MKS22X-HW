import java.util.*;
import java.io.*;
public class Driver05{

    public static void main(String[]args) throws FileNotFoundException {
        Maze f;
        f = new Maze("data3.dat",true);//true animates the maze.
        
        f.clearTerminal();
        f.solve();

        f.clearTerminal();
        System.out.println(f);
    }
}
