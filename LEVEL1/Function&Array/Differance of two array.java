import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0; i<n1; i++){
        arr1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0; i<n2; i++){
        arr2[i] = scn.nextInt();
    }

    int n3 = n2;
    int arr3[] = new int[n3];

    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = arr3.length - 1;

    int borrow = 0;

    while(k>=0){

        int diff = 0;
        
        if(j>=0){
            diff += arr2[j];
        }

        if(i>=0){
            diff -= arr1[i];
        }

        diff = diff - borrow;

        if(diff < 0){
            diff += 10; 
            borrow = 1;
        }
        else {
            borrow = 0;
        }

        arr3[k] = diff;

        i--;
        j--;
        k--;

    }

    for(int n = 0; n<arr3.length; n++){
        if(n == 0 && arr3[n] == 0){

        }
        else{
            System.out.println(arr3[n]);
        }
        
    }

 }

}