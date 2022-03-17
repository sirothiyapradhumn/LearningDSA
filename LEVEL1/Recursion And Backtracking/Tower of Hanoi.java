import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();
        toh(n, t1,t2, t3);
    }

    public static void toh(int n, int t1, int t2, int t3){
        if(n==0) return;
        //faith 1
        toh(n-1, t1, t3,t2);
        //myWork move nth disk from t1->t2
        System.out.println(n+"["+t1+" -> "+t2+"]");
        //faith 2
        toh(n-1, t3, t2, t1);
    }

}