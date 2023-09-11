const arr = [ 10, 9 , 30 , 50 ,9, 30];

const findMaxAndSecMax = (arr) => {
  const setArray = Array.from(new Set(arr));
  setArray.sort((a,b) => a-b);
  console.log(setArray);
  return setArray.at(-2);
}

console.log(findMaxAndSecMax(arr))

