import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        // base condition ->1
        if(n==0){
            return;
        }
        //my work ->2
        System.out.println(n);
        // faith ->3
        printDecreasing(n-1);
    }

}