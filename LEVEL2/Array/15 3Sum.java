class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        //sort the nums array
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            
            //two pointer approch
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum == 0){
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[left]);
                    subAns.add(nums[right]);
                    
                    ans.add(subAns);
                    
                    //check1-> left == left+1
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    
                    //check2-> right == right-1
                    while(left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    
                    left++;
                    right--;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
            
            //check3-> i == i+1
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        
        return ans;
    }
}