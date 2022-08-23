class Solution {
    public int helper(String s, int idx, int[] dp){
        //base case 
        if(idx == s.length()){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return dp[idx] = 0;
        } 
        
        //1st call
        int count = helper(s, idx+1, dp);
        
        //2nd call
        if(idx < s.length()-1){
            char ch2 = s.charAt(idx+1);
            int num = (ch1 - '0')*10 + (ch2 - '0');
            
            if(num<=26){
                count += helper(s, idx+2, dp);
            }
            
        }
        
        return dp[idx] = count;
    }
    
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        
        int dp[] = new int[n+1];
        
        Arrays.fill(dp, -1);
        
        //uncomment 46th line for memorization code
        // return helper(s, 0, dp);
        
        //tabulaton code 
        dp[n] = 1;
        for(int i = n-1; i>=0; i--){
            char ch1 = s.charAt(i);
            
            if(ch1 == '0'){
                dp[i] = 0;
                continue;
            } 

            //consider single character
            int count = dp[i+1];

            //consider two character
            if(i < s.length()-1){
                char ch2 = s.charAt(i+1);
                int num = (ch1 - '0')*10 + (ch2 - '0');

                if(num<=26){
                    count += dp[i+2];
                }

            }

            dp[i] = count;
        }
        
        return dp[0];
    }
}