class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String text1,String text2,int n,int m)
    {
        //Your code here
        int dp[][] = new int [n+1][m+1];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        
        
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
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n+m-dp[n][m];
    }
}