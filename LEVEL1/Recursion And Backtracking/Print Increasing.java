import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n);
    }

    public static void printIncreasing(int n){
        //Base condition ->1
        if(n == 0){
            return;
        }
        //faith ->2
        printIncreasing(n-1);
        // my work ->3
        System.out.println(n);
    }

}