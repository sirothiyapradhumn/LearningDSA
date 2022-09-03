
class Solution{   
    
    static boolean isPalindrom(String str, int left, int right){
        
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    static int helper(String str, int i, int j, int dp[][]){
        
        if(i>=j) return dp[i][j] = 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(isPalindrom(str, i, j) == true){
            return dp[i][j] = 0;
        } 
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k<j; k++){
            int ans1 = helper(str, i, k, dp);
            int ans2 = helper(str, k+1, j, dp);
            int myAns = 1;
            
            myAns += ans1+ ans2;
            
            if(ans > myAns){
                ans = myAns;
            }
        }
        
        return dp[i][j] = ans;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        int dp[][] = new int[n+1][n+1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        
        return helper(str, 0, n-1, dp);
    }
}