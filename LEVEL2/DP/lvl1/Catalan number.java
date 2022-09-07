import java.io.*;
import java.util.*;

public class Main{

public static int catalanNumber(int n, int dp[]){
    if(n <= 1){
        return dp[n] = 1;
    }
    if(dp[n] != -1){
        return dp[n];
    }

    int ans = 0;
    for(int i =0; i<n; i++){
        ans += catalanNumber(i, dp) * catalanNumber(n-i-1, dp);
    }

    return dp[n] = ans;
}   

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
 
    int n = scn.nextInt();
    int dp[] = new int[n+1];
    //Arrays.fill(dp, -1);
    // int ans = catalanNumber(n, dp);

    // System.out.println(ans);

    dp[0] = 1;
    dp[1] = 1;

    for(int i =2; i<=n; i++){
        for(int j = 0; j<i; j++){
            dp[i] += (dp[j] * dp[i-j-1]);
        }
    }

    System.out.println(dp[n]);
 }

}