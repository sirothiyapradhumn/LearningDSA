class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        // //base case 
        // if(sum<0) return false;
        
        // if(N==0){
        //     if(sum==0){
        //         return true;
        //     }
        //     else {
        //         return false;
        //     }
        // }
        
        // boolean include = isSubsetSum(N-1, arr, sum-arr[N-1]);
        // boolean exclude = isSubsetSum(N-1, arr, sum);
         
        // return include || exclude;
        
        Boolean dp[][] = new Boolean[N+1][sum+1];
        
        for(int j = 0; j<=sum; j++){
            dp[0][j] = false;
        }
        
        for(int i = 0; i<=N; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=sum; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][sum];
    }
}