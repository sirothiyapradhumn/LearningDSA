class Solution {
    
    public int memo_fibo(int n, int dp[]){
        //base case
        if(n<=1){
            return dp[n] = n;
        }
        
        //memo step
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = memo_fibo(n-1, dp)+memo_fibo(n-2, dp);
        
        //returing and store
        return dp[n] = ans;
    }
    
    /*  // recursive code
    public int recr_fibo(int n){
        if(n<=1){
            return n;
        }
        
        int ans = recr_fibo(n-1)+recr_fibo(n-2);
        return ans;
    }
    */
    public int fib(int n) {
        // int ans = recr_fibo(n);
        // return ans;
        
        int dp[] = new int[n+1];
        for(int i =0; i<=n; i++){
            dp[i] = -1;
        }
        
        int ans = memo_fibo(n, dp);
        
        return ans;
    }
}