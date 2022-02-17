import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i<n; i++){
        arr[i] = scn.nextInt();
    }

    int max = maxElement(arr);
    printBar(arr, max);
 }

public static int maxElement(int arr[]){
    int max = arr[0];
    for(int i = 0; i<arr.length; i++){
        if(max < arr[i]){
            max = arr[i];
        }
    }

    return max;
}

public static void printBar(int arr[], int max){
    for(int i = max; i>=1; i--){
        for(int j = 0; j<arr.length; j++){
            if(i>arr[j]){
                System.out.print("\t");
            }
            else {
                System.out.print("*\t");
            }
        }
        System.out.println();
    }
}

}