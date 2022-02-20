import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);

    //Array 1st
    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0; i<n1; i++){
        arr1[i] = scn.nextInt();
    }

    //Array 2nd
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0; i<n2; i++){
        arr2[i] = scn.nextInt();
    }

    // Array 3rd n1 or n2 -> Mai Jo Max hoga vo size Hoga
    int n3 = Math.max(n1,n2) + 1;
    int[] arr3 = new int[n3];

    // last index of all array -> Sum kai liye
    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = arr3.length - 1;  

    
    int carry = 0;
        
        
    while(k>=0){

        int sum = 0;
        
        // checking idx in arr1
        if(i>=0){
            sum += arr1[i];
        }

        // checking idx in arr2
        if(j>=0){
            sum += arr2[j];
        }

        sum += carry;

        int check1 = sum % 10;
        int check2 = sum / 10;

        arr3[k] = check1;
        carry = check2;

        // updating value
        i--;
        j--;
        k--;

    }

    for(int n = 0; n <n3; n++){
        if( n == 0 && arr3[n] == 0){
            // do noThing
        }
        else {
            System.out.println(arr3[n]);
        }
    }
 }

}