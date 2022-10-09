//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        pair np = new pair(-1, -1);
        
        int low = 0;
        int high = v.length-1;
  
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(v[mid] == x){
                np.first = mid;
                high = mid-1;
            }
            else if(v[mid] > x){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        int low1 = 0;
        int high1 = v.length-1;
        
        while(low1<=high1){
            int mid1 = low1 + (high1-low1)/2;
            
            if(v[mid1] == x){
                np.second = mid1;
                low1 = mid1+1;
            }
            else if(v[mid1] > x){
                high1 = mid1-1;
            }
            else{
                low1 = mid1+1;
            }
        }
        
        return np;
        
    }
}