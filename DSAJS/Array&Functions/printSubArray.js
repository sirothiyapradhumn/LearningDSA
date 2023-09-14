function subArray(nums) {
  for(let i = 0; i<nums.length; i++){
    console.log(nums.slice(0, i+1))
  }
}

const nums = [10, 20, 30, 40];

subArray(nums);


