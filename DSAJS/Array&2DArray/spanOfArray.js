function spanOfArray(nums) {
  let min = nums[0], max = nums[0];
  for(let i in nums) {
    if(min > nums[i]) {
      min = nums[i];
    }
    if(max < nums[i]) {
      max = nums[i];
    }
  }
  return max - min;
}

const nums = [5, 3, 6, 1, 7];
console.log(spanOfArray(nums));

// T.C O(n)
// S.C O(1)