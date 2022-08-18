import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int ans = cs_recur(n);

        int dp[] = new int[n+1];

        int ans1 = cs_memo(n, dp);

        int ans2 = cs_tabu(n, dp);

        // System.out.println(ans);

        // System.out.println(ans1);

        System.out.println(ans2);
    }


    // recursive code
    public static int cs_recur(int n){
        if(n<0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        int ans = cs_recur(n-1)+cs_recur(n-2)+cs_recur(n-3);

        return ans;
    }

    //memorization code
    public static int cs_memo(int n, int[] dp){
        
        if(n<0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(dp[n]>0){
            return dp[n];
        }

        int ans = cs_memo(n-1, dp)+cs_memo(n-2, dp)+cs_memo(n-3, dp);

        return dp[n] = ans;
    }


    // tabulation code
    public static int cs_tabu(int n, int[] dp){
        
        dp[0] = 1;

        for(int i = 1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else if( i == 2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }

}