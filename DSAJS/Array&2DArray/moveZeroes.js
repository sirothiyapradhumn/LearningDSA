// 283. Move Zeroes
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]


//by Inbuild function
// T.C O(n)
function moveZeros(arr){
  for(let i = arr.length; i>=0; i--){
    if(arr[i] === 0) {
      arr.splice(i,1);
      arr.push(0);
    }
  }
  return arr;
}

console.log(moveZeros([0, 0,1,0,3,12]))

// Two pointer approach
// T.C O(n)
var moveZeroesTwoPointer = function(nums) {
  let i = 0; 
  let j = i+1;

  while(j <= nums.length -1){
    if(nums[i] !== 0){
      i++;
      j++;
    }
    else {
      if( nums[j] !== 0){
        [nums[i], nums[j]] = [nums[j], nums[i]];
        i++;
      }
      j++;
    } 
  }
  return nums;
};

console.log(moveZeroesTwoPointer([0,1,0,3,12]))