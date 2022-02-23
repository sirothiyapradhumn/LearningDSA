import java.io.*;
import java.util.*;

public class Main{

public static void binarySearchForBrokenEco(int arr[], int data){
    int left = 0;
    int right = arr.length-1;

    int ceil = 0;
    int floor = 0;

    while(left <= right){
        int mid = (left+right) / 2;
        if(arr[mid] == data){
            floor = arr[mid];
            ceil = arr[mid];
            break;
        }
        else if(arr[mid] < data){
            left = mid + 1;
            // ho sakta hai ki floor ki value yai ho, so update
            floor = arr[mid];
        } 
        else {
            right = mid - 1;
             // ho sakta hai ki ceil ki value yai ho, so update
            ceil = arr[mid];
        }
    }

    System.out.println(ceil);
    System.out.println(floor);
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];

    for(int i = 0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    
    int data = scn.nextInt();

    binarySearchForBrokenEco(arr, data);

 }

}