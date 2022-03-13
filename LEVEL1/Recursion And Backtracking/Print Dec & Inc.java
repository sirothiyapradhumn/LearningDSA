import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pdi(n);
    }

    public static void pdi(int n){
        //Base condition
        if(n==0) return;

        System.out.println(n); // my work
        pdi(n-1); //faith
        System.out.println(n);// my work;
    }

}