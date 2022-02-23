import java.io.*;
import java.util.*;

public class Main{

// first index find karne kai liye
public static int binarySearchForFirstIdx(int arr[], int data){
    int left = 0;
    int right = arr.length-1;

    int firstIdx = -1;

    while(left <= right){
        int mid = (left+right) / 2;
        
        if(arr[mid] == data){
            right = mid - 1;
            firstIdx = mid;
        }
        else if(arr[mid] < data){
            left = mid + 1;
        } 
        else {
            right = mid - 1;
        }
    }

    return firstIdx;  

}

// last index find karne kai liye
public static int binarySearchForLastIdx(int arr[], int data){
    int left = 0;
    int right = arr.length-1;

    int lastIdx = -1;

    while(left <= right){
        int mid = (left+right) / 2;
        
        if(arr[mid] == data){
            left = mid + 1;
            lastIdx = mid;
        }
        else if(arr[mid] < data){
            left = mid + 1;
        } 
        else {
            right = mid - 1;
        }
    }

    return lastIdx;  

}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];

    for(int i = 0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    
    int data = scn.nextInt();

    int first = binarySearchForFirstIdx(arr, data);
    
    int last = binarySearchForLastIdx(arr, data);

    System.out.println(first);
    System.out.println(last);

 }

}