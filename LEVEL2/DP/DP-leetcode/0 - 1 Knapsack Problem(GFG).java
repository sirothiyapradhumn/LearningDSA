class Solution 
{   
    static int helper(int W, int wt[], int val[], int n, int dp[][]){
        
        //base case 
         if(W==0 || n ==0){
             return 0;
         }
         
         //memo code
         if(dp[n][W] != -1){
             return dp[n][W];
         }
         
         if(W >= wt[n-1]){
             int include = helper(W-wt[n-1], wt, val, n-1, dp) + val[n-1];
             int exclude = helper(W, wt, val, n-1, dp);
             
             return dp[n][W] = Math.max(include, exclude);
         }
         else{
             return dp[n][W] = helper(W, wt, val, n-1, dp);
         }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[n+1][W+1];
         for(int a[] : dp){
             Arrays.fill(a, -1);
         }
         
         //return helper(W, wt, val, n, dp);
         
         for(int i =0; i<=n;i++){
             for(int j = 0; j<=W; j++){
                 if(i==0 || j ==0){
                     dp[i][j] = 0;
                 }
                 else if(j>=wt[i-1]){
                     dp[i][j] = Math.max(dp[i-1][j-wt[i-1]]+val[i-1], dp[i-1][j]);
                 }
                 else{
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
        return dp[n][W];
    } 
}


