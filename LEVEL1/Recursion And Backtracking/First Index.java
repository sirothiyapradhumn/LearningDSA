import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int ans  = firstIndex(arr, 0, x);
        System.out.println(ans);
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length) return -1;


        if(x==arr[idx]){
            return idx;
        }
        else{
            int ans = firstIndex(arr, idx+1, x);
            return ans;
        }
    }

}