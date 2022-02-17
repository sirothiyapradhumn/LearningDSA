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
    int d = scn.nextInt();
    int ans = findIdx(arr, d);
    System.out.println(ans);

 }

 public static int findIdx(int arr[], int d){
    int ans = -1;
    for(int i = 0; i<arr.length; i++){
        if(arr[i] == d){
            ans = i;
            break;
        }
    }
    return ans;
 } 

}