import java.io.*;
import java.util.*;

public class Main{

public static int decimalToBinary(int n){
    int count = 0;
    int ans = 0;
    while(n!=0){
        // n%2 kyuki hame binary no. chiye joki 2 sai ayega.
        int rem = n % 2; 
        int po = (int)Math.pow(10, count);
        ans += rem*po;
        count++;
        n /= 2;
    }
    return ans;
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0; i<n; i++){
        arr[i] = scn.nextInt();
    }

    // subset of array -> 2 ki power n.
    int subset = (int)Math.pow(2, n);

    for(int i = 0; i<subset; i++){

        //decimal To Binary
        int binary = decimalToBinary(i);

        // div = 100  left to right tranvers kar paye
        int div = (int)Math.pow(10, n-1); 

        for(int j = 0; j<arr.length; j++){

            int q = binary / div;

            int rem = binary % div;

            if(q == 1){
                System.out.print(arr[j]+"\t");
            }
            else {
                System.out.print("-\t");
            }

            // updating values
            binary = rem;
            div /= 10;
        }
        System.out.println();
    }
 }

}