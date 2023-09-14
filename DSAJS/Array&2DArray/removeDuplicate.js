// Ques 3 - Remove Duplicates from Sorted Array
// Given an integer array nums sorted in non-decreasing order, remove
// the duplicates in-place such that each unique element appears
// only once.The relative order of the elements should be kept
// the same.Then return the number of unique elements in nums.

// Input: [1,1,2]               ----->>>>>  Output: 2, [1,2,_]
// Input: [0,0,1,1,1,2,2,3,3,4] ----->>>>>  Output: 5, [0,1,2,3,4,_,_,_,_,_]


// T.C O(n)
// S.C O(1)
function removeDuplicate(nums) {
  for(let i =0; i<nums.length -1; i++){
    console.log(i)
    if(nums[i] === nums[i+1]){
      nums.splice(i+1, 1);
      i--;
      console.log(i);
    }
  }
  return nums;
}

console.log(removeDuplicate([0,0,1,1,1,2,2,2,3,3,4]));