import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String asf) {
        //+ve base case
        if(n==0){
            System.out.println(asf);
            return;
        }
        //-ve base case
        if(n<0){
            return;
        }

        //faith
        printStairPaths(n-1, asf+"1");
        printStairPaths(n-2, asf+"2");
        printStairPaths(n-3, asf+"3");
    }

}