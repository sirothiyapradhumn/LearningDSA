import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n){
        //base condition
        if(n == 0) return;

        
        System.out.print(n+" "); // pre
        pzz(n-1);                // leftcall
        System.out.print(n+" "); // in
        pzz(n-1);                // rightcall
        System.out.print(n+" "); // post
        

    }

}