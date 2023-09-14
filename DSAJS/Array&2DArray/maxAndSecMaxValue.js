const arr = [ 10, 9 , 30 , 50 ,9, 30];

//T.C O(nLogN)
//S.C O(n)
const findMaxAndSecMax = (arr) => {
  const setArray = Array.from(new Set(arr));
  setArray.sort((a,b) => a-b);
  console.log(setArray);
  return setArray.at(-2);
}

console.log(findMaxAndSecMax(arr))

function secondLargestOptimised (nums) {
  let largest = Number.NEGATIVE_INFINITY;
  let secondLargest = Number.NEGATIVE_INFINITY;

  for(let i =0; i<nums.length; i++){
    if(arr[i] > largest) {
      secondLargest = largest;
      largest = arr[i];
    }
    else if( arr[i] !== largest && arr[i] > secondLargest){
      secondLargest = arr[i];
    }
  }

  return {
    largest,
    secondLargest
  }
}

console.log(secondLargestOptimised(arr));