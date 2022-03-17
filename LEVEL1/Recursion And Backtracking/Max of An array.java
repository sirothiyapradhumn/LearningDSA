import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int ans = maxOfArray(arr, 0);
        System.err.println(ans);
    }

    public static int maxOfArray(int[] arr, int idx){
        //base                       -infinity
        if(idx == arr.length) return Integer.MIN_VALUE;
        //faith
        int f1 = maxOfArray(arr, idx+1);
        //mywork
        int max = Math.max(f1, arr[idx]);
        return max;
    }

}