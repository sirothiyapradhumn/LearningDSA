// Arrays in Javascript

// Decalaration
let person = {
  name: "Piyush",
  age: 25,
};

let arr = ["apple", "banana", "cherry", person];

console.log(arr.length); // know the length of an array

// # Add and Remove Elements

// Add to End of the Array
arr.push("orange");
console.log(arr);

// Remove From End of the Array
arr.pop();
arr.pop();
console.log(arr);

// Add to Top of the Array
arr.unshift("orange");
console.log(arr);

// Remove From Top of the Array
arr.shift();
console.log(arr);

// # Looping Arrays

// For Loop
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

// While Loop
let i = 0;
while (i < arr.length) {
  console.log(arr[i]);

  i++;
}

// # Inbuilt Loop Methods
const numbers = [1, 2, 3, 4, 5];

// map in javascript
const arrayMap = numbers.map((item, index, array) => {
  return item + 5;
});
console.log(arrayMap);

// filter in javascript
const arrFilter = numbers.filter((item, index, array) => {
  return item > 3;
});
console.log(arrFilter);

// reduce in javascript
const arrReduce = numbers.reduce((prev, item) => {
  return prev + item;
}, 2);
console.log(arrReduce);

// some in javascript
const arrSome = numbers.some((item, index, array) => {
  return item > 3;
});
console.log(arrSome);

// every in javascript
const arrEvery = numbers.every((item, index, array) => {
  return item < 10;
});
console.log(arrEvery);

// find in javascript
const arrFind = numbers.find((item, index, array) => {
  return item > 3;
});
console.log(arrFind);

// findIndex
const arrFin = [1, 2, 3];
const index = arrFin.findIndex((item) => item === 2);
console.log(index);

// Spread and Rest Operators
const nums = [1, 2, 3];
const nums2 = [4, 5, 6, 7];

const finalNums = [...nums, ...nums2]; // Spread Operator
console.log(finalNums);

// Rest Operator
function sum(...numbers) {
  return numbers;
}

console.log(sum(nums, nums2, 5, "hello"));

// # More Array Methods

// concat
const arrConcat = nums.concat(nums2, arr);
console.log(arrConcat)

// Slice
console.log(arr);
const arrSlice = arr.slice(0,2);
console.log(arrSlice)


// Splice
arr.splice(1, 2, "orange");
console.log(arr)

// Fill
const dummy = [2, 5, 1, 6];
dummy.fill('*', 2);
console.log(dummy);
dummy.fill(0);
console.log(dummy);


// Flat
const flatEx = [1, [2, 3], [[4, 5], 6]]; // => [1,2,3,4,5,6]

const flattenedArray = flatEx.flat(2);
console.log(flattenedArray);

// reverse
nums.reverse();
console.log(nums);

// sort
const unsorted = [5, 2, 10, 7, 3, 1];
unsorted.sort((a, b) => b - a);
console.log(unsorted);
