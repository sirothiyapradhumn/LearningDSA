class Solution{
    
    static int helper(int n, int W, int val[], int wt[], int dp[][]){
        //basse case
        if(n ==0 || W ==0 ) return 0;
        
        if(dp[n][W] != -1 ) return dp[n][W];
        
        if(W >= wt[n-1]){
            int include = helper(n, W-wt[n-1], val, wt, dp) + val[n-1];
            int exclude = helper(n-1, W, val, wt, dp);
            
            return dp[n][W] = Math.max(include, exclude);
        }
        else{
            return dp[n][W] = helper(n-1, W, val, wt, dp);
        }
        
    }
    
    static int knapSack(int n, int W, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[n+1][W+1];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        
        // int ans = helper(n, W, val, wt, dp);
        // return ans;
        
        for(int i =0; i<=n; i++){
            for(int j =0; j<=W; j++){
                if(i ==0 || j ==0){
                    dp[i][j] = 0;
                }
                else if( j >= wt[i-1]){
                    dp[i][j] = Math.max(dp[i][j-wt[i-1]] + val[i-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][W];
    }
}