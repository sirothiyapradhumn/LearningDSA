class Solution 
{ 
    int minDeletions(String s, int n)
    {
        // code here
        int dp[][] = new int[n][n];
        //Tabulation
        for(int gap = 0; gap<n; gap++){
            for(int i = 0, j=gap; j<n; j++, i++){
                if(i>=j){
                    dp[i][j] = (i==j)?1:0;
                    continue;
                }
                
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return n-dp[0][n-1];
    }
} 