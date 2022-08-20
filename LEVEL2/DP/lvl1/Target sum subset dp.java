import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        // boolean ans = tss(arr, 0, tar);
        // System.out.println(ans);

        boolean dp[][] = new boolean[n+1][tar+1];

        for(int i =0; i<=n; i++){
            for(int j = 0; j<=tar; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }
                else if(j ==0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j] == true){
                        //for exclude
                        dp[i][j] = true;
                    }
                    else{
                        //for include
                        int currVal = arr[i-1];
                        int tarIdx = j-currVal;
                        if(tarIdx >=0 && dp[i-1][tarIdx] == true){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][tar]);
    }

    public static boolean tss(int[] arr, int idx, int tar){

        if(idx == arr.length){
            if(tar == 0){
                return true;
            }
            else{
                return false;
            }
        }

        //yes call
        boolean ans1 = tss(arr, idx+1, tar-arr[idx]);

        // no call
        boolean ans2 = tss(arr, idx+1, tar);

        return ans1 || ans2;
        
    }
}