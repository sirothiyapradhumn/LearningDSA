class Solution {
    public int helper(int num){
        long low = 1;
        long high = num;
        
        while(low<=high){
            long mid = low + (high-low)/2;
            long sqr = mid * mid;
            
            if(sqr == num){
                return (int)mid;
            }
            else if(sqr > num){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return (int)high;
    }
    public boolean isPerfectSquare(int num) {
        int ans = helper(num);
        
        if(ans * ans == num){
            return true;
        }
        
        return false;
    }
}