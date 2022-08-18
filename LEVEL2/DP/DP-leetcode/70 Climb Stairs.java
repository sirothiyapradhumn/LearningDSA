class Solution {
    
    /*
    //recursive_code
    public int helper_recu(int n){
        if(n<0) return 0;
        if(n == 0) return 1;
        
        int ans = helper_recu(n-1)+helper_recu(n-2);
        
        return ans;
    }
    */
    
    /*
    //memoization code
    public int helper_memo(int n, int[] dp){
        if(n<0){
            return 0;
        }
            
        if( n==0){
            return dp[n] = 1;
        }
        
        if(dp[n]!= -1){
            return dp[n];
        }
        
        int ans = helper_memo(n-1, dp) + helper_memo(n-2, dp);
        dp[n] = ans;
        return ans;
    }
    */
    
    // tabulation code
    public int helper_tabu(int n, int[] dp){
        
        dp[0] = 1;
        
        for(int i = 1; i<=n; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        
        return dp[n];
    }
    
    public int climbStairs(int n) {
        //int ans = helper_recu(n);
        
        /*
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);                  
        int ans = helper_memo(n, dp);
        */
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1); 
        int ans = helper_tabu(n, dp);
        
        return ans;
    }
}