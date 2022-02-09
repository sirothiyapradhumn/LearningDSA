import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nst = n;
    int nsp = 0;

    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=nsp; j++){
            System.out.print("\t");
        }
        for(int k = 1; k<=nst; k++){
            if(i>n/2+1 && i<n && k>1 && k<nst){
                System.out.print("\t");
            }
            else {
                System.out.print("*\t");
            }
        }
        System.out.println();
        if(i<=n/2){
            nsp++;
            nst -= 2;
        }else {
            nsp--;
            nst += 2;
        }
    }
 }

}