import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here

   //step01
   int size= max-min+1;
   int farr[] = new int[size];

   //step02 count frequncey of each element
   for(int i =0; i<arr.length; i++){
     int idx = arr[i] - min;
     farr[idx]++;
   }
   
   //step03 Prefix sum
   for(int i =1; i<size; i++){
     farr[i] = farr[i] + farr[i-1];
   }

   //step 04 travel right to left , ans fill
   int ans[] = new int[arr.length];

   for(int i = arr.length-1; i>=0; i--){
     int idx = arr[i]-min;
     int pos = farr[idx];
     ans[pos-1] = arr[i];
     farr[idx]--;
   }

   for(int i = 0; i<arr.length; i++){
     arr[i] = ans[i];
   }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}