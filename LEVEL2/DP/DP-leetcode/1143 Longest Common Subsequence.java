class Solution {
    
    public int helper(String t1, String t2, int n, int m, int dp[][]){
        
        if(n == 0 || m == 0){
            return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(t1.charAt(n-1) == t2.charAt(m-1)){
            return dp[n][m] = helper(t1, t2, n-1, m-1, dp)+1;
        }
        else{
            return dp[n][m] = Math.max(helper(t1, t2, n, m-1, dp), helper(t1, t2, n-1, m, dp));
        }
    }
        
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int [n+1][m+1];
        
        // for(int a[] : dp){
        //     Arrays.fill(a, -1);
        // }
        
        //int ans = helper( text1,  text2, n, m, dp);
        //return ans;
        
        //Tabulation code
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}