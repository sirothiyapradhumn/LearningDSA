class Solution{
    int longestCommonSubstr(String text1, String text2, int n, int m){
        // code here
        int dp[][] = new int [n+1][m+1];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        
        
        //Tabulation code
        int maxAns = 0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    maxAns = Math.max(maxAns, dp[i][j]);
                }
                else{
                    dp[i][j] =0;
                }
            }
        }
        return maxAns;
    }
}