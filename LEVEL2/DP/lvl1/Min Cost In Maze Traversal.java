import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int arr[][] = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int dp[][] = new int[n][m];
        
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }

        int ans = mcmt(arr, 0, 0, dp);

        int ans1 = mcmt_tabu(arr, dp);

        System.out.println(ans1);
    }

    public static int mcmt(int arr[][], int sr, int sc, int dp[][]){
        
        if(sr == arr.length -1 && sc == arr[0].length-1){
            return arr[sr][sc];
        }

        if(sr>=arr.length || sc>=arr[0].length){
            return 100001;
        }

        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }

        int min = Integer.MAX_VALUE;
        int ans1 = mcmt(arr, sr+1, sc, dp);
        int ans2 = mcmt(arr, sr, sc+1, dp);

        min = Math.min(ans1, ans2) + arr[sr][sc];

        return dp[sr][sc] = min;
    }

    public static int mcmt_tabu(int arr[][], int dp[][]){


        for(int i = arr.length -1; i>=0; i--){
            for(int j = arr[0].length -1; j>=0; j--){
                if(i == arr.length -1 && j == arr[0].length -1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == arr.length -1){
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }
                else if(j == arr[0].length -1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + arr[i][j];
                }
            }
        }

        return dp[0][0];
    }

}