class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int wt[] = new int[n];
        for(int i=0; i<n; i++){
            wt[i] = i+1;
        }
        
        int W = n;
        
        
        int dp[][] = new int[n+1][W+1];
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        
        
        for(int i =0; i<=n; i++){
            for(int j =0; j<=W; j++){
                if(i ==0 || j ==0){
                    dp[i][j] = 0;
                }
                else if( j >= wt[i-1]){
                    dp[i][j] = Math.max(dp[i][j-wt[i-1]] + price[i-1], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][W];
        
    }
}