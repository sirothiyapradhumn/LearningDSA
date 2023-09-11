// Ques- Rotate Array by K
// Given an integer array nums, rotate the array to the right by k steps,
// where k is non - negative.

// Input: nums = [1,2,3,4,5,6,7], k = 3  ----->>>>>  Output: [5,6,7,1,2,3,4]
// Input: nums = [-1,-100,3,99], k = 2   ----->>>>>  Output: [3,99,-1,-100]

const arr = [1,2,3,4,5,6,7];

// by inbuild function

const rotateAnArray = (arr, k) => {
  let size  = arr.length;
  if(k > size){
    k = k % size;
  }
  if(k<0){
    k = k + size; 
  }

  arr.unshift(...arr.splice(size-k));
  return arr;
}

console.log(rotateAnArray(arr, 3));

function rotateArray( arr, k) {
  let size  = arr.length;
  if(k > size){
    k = k % size;
  }
  if(k<0){
    k = k + size; 
  }

  reverseArray(arr, 0, size-1);
  reverseArray(arr, 0, k-1);
  reverseArray(arr, k, size-1);

  return arr;
}

function reverseArray( arr, i , j) {
  while( i < j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    i++;
    j--;
  }
}

console.log(rotateArray([1,2,3,4,5,6,7], 3));