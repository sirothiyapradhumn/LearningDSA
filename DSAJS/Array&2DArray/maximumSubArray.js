//53. Maximum Subarray
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

//brute force
// T.C O(n^2)
// S.C O(1)
function maxSubarry (nums) {
  let maxSum = nums[0];
  let startIdx = 0;
  let lastIdx = 0;

  for(let i =0; i<nums.length; i++) {
    let currentSum = 0;
    for (let j = i; j < nums.length; j++) {
      currentSum = currentSum+nums[j];
      if(currentSum > maxSum){
        maxSum = currentSum;
        startIdx = i;
        lastIdx = j;
      }
    }
  }

  return {
    sum: maxSum,
    maxSubArray: nums.slice(startIdx, lastIdx+1)
  } 
}

console.log(maxSubarry([-2,1,-3,4,-1,2,1,-5,4]))

// Kadana algo
// T.C O(n);
// S.C O(1)
function subArrayKadane (nums) {
  let maxSum = nums[0];
  let currentSum = 0;
  for(let i =0; i<nums.length; i++){
    currentSum += nums[i];

    if(currentSum > maxSum) {
      maxSum = currentSum;
    }

    if(currentSum < 0){
      currentSum = 0;
    }
  }

  return maxSum;
}

console.log(subArrayKadane([-2,1,-3,4,-1,2,1,-5,4]))