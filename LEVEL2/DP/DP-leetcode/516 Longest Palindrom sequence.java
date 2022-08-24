class Solution {
    
    public int helper(String s, int i, int j, int[][] dp){
        //base case 
        if(i>=j){
            return dp[i][j] = (i==j)?1:0;
        }
        
        //memo code 
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = helper(s, i+1, j-1, dp)+2;
        }
        else{
            return dp[i][j] = Math.max(helper(s, i+1, j, dp), helper(s, i, j-1, dp));
        }
    }
    
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        int [][]dp = new int[n][n];
        
//         int ans = helper(s, 0, n-1, dp);
        
//         //observation
//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<n; j++){
//                 System.out.print(dp[i][j]+" ");
//             }
//             System.out.println();
//         }
        
//         return ans;
         
        
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
        
        return dp[0][n-1];
    }
}