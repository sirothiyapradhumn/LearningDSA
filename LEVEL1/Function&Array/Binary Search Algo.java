import java.io.*;
import java.util.*;

public class Main{

public static int binarySearch(int arr[], int data){
    int left = 0;
    int right = arr.length-1;

    while(left <= right){
        int mid = (left+right) / 2;
        if(arr[mid] == data){
            return mid;
        }
        else if(arr[mid] < data){
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return -1;

}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];

    for(int i = 0; i<n; i++){
        arr[i] = scn.nextInt();
    }

    int data = scn.nextInt();

    int res = binarySearch(arr, data);
    System.out.println(res);

 }

}

/*
10
1
5
10
15
22
33
40
42
55
66
15

o/p   --->  3
*/