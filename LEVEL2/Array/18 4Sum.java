class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length <4) return ans;
        
        Arrays.sort(nums);
        
        for(int i =0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int left = j+1;
                int right = nums.length-1;
                
                double remainSum = (double)target-nums[i]-nums[j];
                    
                while(left<right){
                    
                    int sum = nums[left]+nums[right];
                    
                    if(sum == remainSum){
                        List<Integer>subAns = new ArrayList<>();
                        subAns.add(nums[i]);
                        subAns.add(nums[j]);
                        subAns.add(nums[left]);
                        subAns.add(nums[right]);
                        
                        ans.add(subAns);
                        
                        while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        
                        while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        
                        right--;
                        left++;
                    }
                    else if(sum>remainSum){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
                
                while(j<nums.length-1 && nums[j]==nums[j+1]){
                    j++;
                }
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        
        return ans;
    }
}