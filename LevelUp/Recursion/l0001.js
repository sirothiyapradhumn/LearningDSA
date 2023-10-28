const printDec = (num) => {
  if(num === 0) {
    return;
  }
  console.log(num);
  printDec(num-1);
}
// printDec(5);

/*--------------------------------------------------------------------- */

function printInc(num) {
  if(num === 0) {
    return;
  }
  printInc(num-1);
  console.log(num);
}
// printInc(5);

/*--------------------------------------------------------------------- */

function printEvenOdd(num) {
  if(num === 0) {
    return;
  }
  if(num%2 === 0) console.log(num);
  printEvenOdd(num-1);
  if(num%2 !== 0) console.log(num);
}
// printEvenOdd(10);

/*--------------------------------------------------------------------- */

function factorial(num) {
  if(num === 0) {
    return 1;
  }
  return num * factorial(num-1);
}
// console.log(factorial(5));

/*--------------------------------------------------------------------- */

function power(num1, num2) {
  if(num2 === 0) {
    return  1;
  }

  return power(num1, num2-1)*num1;
}
// console.log(power(2,4));

/*--------------------------------------------------------------------- */

function printTreePath(num) {
  if(num === 1 || num === 0){
    console.log('base',num);
    return 1;
  }

  let ans = 0;

  console.log('Pre', num);
  ans += printTreePath(num-1);

  console.log('In', num);

  ans += printTreePath(num-2);
  console.log('Post', num);

  return ans+3;
}
// console.log(printTreePath(5));

/*--------------------------------------------------------------------- */

function arrayDisplay(arr, idx) {
  if(idx === arr.length){
    return;
  }
  console.log(arr[idx]);
  arrayDisplay(arr, idx+1);
}
// const tempArr = [10, 20 ,30 ,40, 50, 60];
// arrayDisplay(tempArr, 0);

/*--------------------------------------------------------------------- */

function maxEleArr(arr, idx) {
  if(idx === arr.length){
    return -Infinity;
  }
  return Math.max(maxEleArr(arr, idx+1), arr[idx]);
}
// console.log(maxEleArr([10, 60 ,30 ,40, 50, 10], 0));

/*------------------------------------------------------------------------------------- */

function maxEleArr(arr, idx) {
  if(idx === arr.length){
    return Infinity;
  }
  return Math.min(maxEleArr(arr, idx+1), arr[idx]);
}
// console.log(maxEleArr([10, 60 ,30 ,40, 50, 7], 0));

/*------------------------------------------------------------------------------------- */

function firstIdxNum(arr, idx, num) {
  if(idx === arr.length){
    return -Infinity;
  }
  if(arr[idx] === num) return idx;
  return firstIdxNum(arr, idx+1, num);
}
// console.log(firstIdxNum([60, 10 ,30 ,40, 50, 10], 0, 10));

/*------------------------------------------------------------------------------------- */

function lastIdxNum(arr, idx, num) {
  if(idx === arr.length){
    return -1;
  }
  
  let smallAns = lastIdxNum(arr, idx+1, num);
  if(smallAns !== -1) return smallAns;

  return arr[idx] === num ? idx : -1;
}
// console.log(lastIdxNum([60, 10 ,30 ,40, 10, 50], 0, 10));

/*------------------------------------------------------------------------------------- */

function allIndexNum(arr, idx, num) {
  if(idx === arr.length){
    return new Array;
  }

  let smallAns = allIndexNum(arr, idx+1, num);
  if(arr[idx] === num) smallAns.unshift(idx);

  return smallAns;
}
// console.log(allIndexNum([60, 10 ,10 ,30, 50, 10], 0, 10));

/*------------------------------------------------------------------------------------- */

function stringSubSequance(str, idx, ans) {
  if(str.length === idx){
    console.log(ans);
    return 1;
  }
  let count = 0;
  count += stringSubSequance(str, idx+1, ans+str.charAt(idx));
  count += stringSubSequance(str, idx+1, ans);

  return count;
}
// console.log(stringSubSequance('abc', 0, ""));

/*------------------------------------------------------------------------------------- */

//LC(91)-- TLE -- DP sai hoga
const decodingwAYS = (str, idx) => {
  if(str.length === idx) {
    return 1;
  }

  if(str.charAt(idx) === '0') return 0;
  let count = 0;
  count += decoding(str, idx+1);
  if(idx < str.length-1){
    let num = (str.charAt(idx)-'0')*10 + (str.charAt(idx+1)-'0');
    if(num <= 26){
      count += decoding(str, idx+2);
    }
  }

  return count;
};
// console.log(decodingwAYS('123', 0));

/*------------------------------------------------------------------------------------- */

let codes = [".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz", "+-*", "/%^"];

function getKPC(str, idx, ans){ 
  if(str.length === idx){
    console.log(ans);
    return 1;
  }

  let count = 0;
  let code = codes[str.charAt(idx)-'0']; 
  for(let i=0; i<code.length; i++) {
    count += getKPC(str, idx+1, ans+code.charAt(i));
  }

  if(idx < str.length) {
    let num = (str.charAt(idx)-'0'     )*10+(str.charAt(idx+1)-'0');
    if(num === 10 || num === 11){
      code = codes[num];
      for(let i in code) {
        count += getKPC(str, idx+2, ans+code.charAt(i));
      }
    }
  }

  return count;
}
// console.log(getKPC('789', 0, ""));
// console.log(getKPC('107', 0, ""));

/*------------------------------------------------------------------------------------- */

function printPermutation(str, ans){
  if(str.length === 0) {
    console.log(ans);
    return 1;
  }

  let count =0;
  for(let i =0; i<str.length; i++){
    let ch = str.charAt(i);
    let ros = str.substring(0,i) + str.substring(i+1);
    count += printPermutation(ros, ans+ch);
  }

  return count;
};
// console.log(printPermutation('abc',''));
// console.log(printPermutation('aba',''));

/*------------------------------------------------------------------------------------- */

function printUniquePermutation(str, ans){
  if(str.length === 0) {
    console.log(ans);
    return 1;
  }

  let count =0;
  const vis = new Boolean(26);
  // let vis = new Array(26).fill(false);
  for(let i =0; i<str.length; i++){
    let ch = str.charAt(i);
    if(!vis[ch.charCodeAt(0) - 'a'.charCodeAt(0)]){
      vis[ch.charCodeAt(0) - 'a'.charCodeAt(0)] = true;
      let ros = str.substring(0,i) + str.substring(i+1);
      count += printUniquePermutation(ros, ans+ch);
    }
  }

  return count;
};
// console.log(printUniquePermutation('abc',''));
// console.log(printUniquePermutation('abaa',''));

/*------------------------------------------------------------------------------------- */

function printMazePath(sc, sr, ec, er, ans) {
  if(sc === ec && sr === er) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  if(sc+1 <= ec){
    count += printMazePath(sc+1, sr, ec ,er, ans+"H");
  }
  if(sc+1 <= ec && sr+1 <= er){
    count += printMazePath(sc+1, sr+1, ec ,er, ans+"D");
  }
  if(sr+1 <= er){
    count += printMazePath(sc, sr+1, ec ,er, ans+"V");
  }
  
  return count;
}
// console.log(printMazePath(0, 0, 3, 3, ""));

/*------------------------------------------------------------------------------------- */

function printMazePathJump(sc, sr, ec, er, ans) {
  if (sc === ec && sr === er) {
    console.log(ans);
    return 1;
  }


  let count = 0;
  for (let i = 1; i <= ec - sc; i++) {
    count += printMazePathJump(sc + i, sr, ec, er, ans + "H" + i);
  }
  for (let i = 1; i <= ec - sc && i <= er - sr; i++) { 
    count += printMazePathJump(sc + i, sr + i, ec, er, ans + "D" + i);
  }
  for (let i = 1; i <= er - sr; i++) {
    count += printMazePathJump(sc, sr + i, ec, er, ans + "V" + i);
  }

  return count;
}
// console.log(printMazePathJump(0, 0, 3, 3, ""));

/*------------------------------------------------------------------------------------- */

function floodFill (sr, sc, er, ec, boolVisArr, dir2Darr, dirS, ans) {
  if(sr === er && sc === ec) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  let n = boolVisArr.length;
  let m = boolVisArr[0].length;
  boolVisArr[sr][sc] = true;

  for(let d =0; d<dir2Darr.length; d++) {
    let r = sr+dir2Darr[d][0];
    let c = sc+dir2Darr[d][1];

    if(r>=0 && c>=0 && r<n && c<m && !boolVisArr[r][c]) {
      count += floodFill(r, c, er, ec, boolVisArr, dir2Darr, dirS, ans+dirS[d]);
    }
  }

  boolVisArr[sr][sc] = false;
  return count;
}

function floodFillwithJump (sr, sc, er, ec, boolVisArr, dir2Darr, dirS, ans) {
  if(sr === er && sc === ec) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  let n = boolVisArr.length;
  let m = boolVisArr[0].length;
  boolVisArr[sr][sc] = true;

  for(let d =0; d<dir2Darr.length; d++) {
    for(let rad = 0; rad<=Math.max(n,m); rad++) {
      let r = sr + rad*dir2Darr[d][0];
      let c = sc + rad*dir2Darr[d][1];

      if(r>=0 && c>=0 && r<n && c<m) {
        if(!boolVisArr[r][c]) {
          count += floodFillwithJump(r, c, er, ec, boolVisArr, dir2Darr, dirS, ans+dirS[d]+rad);
        }
      } else {
        break;
      }
    }
  }

  boolVisArr[sr][sc] = false;
  return count;
}

function floodFillQuestions() {
  let vis = Array.from({ length: 3 }, () => Array(3).fill(false));
  
  // let dir = [[1,0], [0,1], [1,1]];
  // let dirS = ['V', 'H', 'D'];
  // let res = floodFill(0, 0, 2, 2, vis, dir, dirS, "");

  let dir = [[1,0], [-1,0], [1,1], [-1,-1], [0,1], [0,-1], [-1,1],[1,-1]];
  let dirS = ['D', 'U', 'S', 'N', 'R', 'L', 'E', 'W'];
  let res = floodFillwithJump(0, 0, 2, 2, vis, dir, dirS, "");

  return res;
} 

// console.log(floodFillQuestions());

/*------------------------------------------------------------------------------------- */

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {
    
  findPath(m,n){
      let res = [];
      if (n === 0 || m[0][0] === 0 || m[n - 1][n - 1] === 0) {
          return res;
      }
          
      const dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];
      const dirS = ["U", "D", "L", "R"];
      
      
      function floodFill (sr, sc, er, ec, visArr, dir2Darr, dirS, ans) {
        if(sr === er && sc === ec) {
          res.push(ans);
          return 1;
        }
      
        let count = 0;
        let n = visArr.length;
        let m = visArr[0].length;
        visArr[sr][sc] = 0;
      
        for(let d =0; d<dir2Darr.length; d++) {
          let r = sr+dir2Darr[d][0];
          let c = sc+dir2Darr[d][1];
      
          if(r>=0 && c>=0 && r<n && c<m && visArr[r][c] != 0) {
            count += floodFill(r, c, er, ec, visArr, dir2Darr, dirS, ans+dirS[d]);
          }
        }
      
        visArr[sr][sc] = 1;
        return count;
      }
      
      floodFill(0, 0, n - 1, n - 1, m, dir, dirS, "");
      res.sort();
      return res;
  }
}

/*------------------------------------------------------------------------------------- */

class pair {
  constructor(longestPathLength, longestPath) {
    this.longestPathLength = longestPathLength;
    this.longestPath = longestPath;
  }
}

function longestPathRecu(sr, sc, er, ec, vis, dir, dirS) {
  if(sr === er && sc === ec) {
    return new pair(0, '');
  }

  let myAns = new pair(-1, '');
  vis[sr][sc] = true;
  for(let d = 0; d < dir.length; d++) {
    let r = sr + dir[d][0];
    let c = sc + dir[d][1];
    if(r >=0 && c >=0 && r<=er && c<=ec && !vis[r][c]) {
      let recAns = longestPathRecu(r, c, er, ec, vis, dir, dirS);

      if(recAns.longestPathLength+1 > myAns.longestPathLength) {
        myAns.longestPathLength = recAns.longestPathLength+1;
        myAns.longestPath = dirS[d] + recAns.longestPath;
      }
    }
  }

  vis[sr][sc] = false;

  return myAns;
}

function showAns() {
  let vis = Array.from({ length: 3 }, () => Array(3).fill(false));
  let dir = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0]
  ];
  let dirS = ["R", "D", "L", "U"];
  return longestPathRecu(0, 0, 2, 2, vis, dir, dirS);
}

// console.log(showAns());

/*------------------------------------------------------------------------------------- */

class pairOne {
  constructor(shortestPathLength, shortestPath) {
    this.shortestPathLength = shortestPathLength;
    this.shortestPath = shortestPath;
  }
}

function shortestPathRecu(sr, sc, er, ec, vis, dir, dirS) {
  if(sr === er && sc === ec) {
    return new pairOne(0, '');
  }

  let myAns = new pairOne(Infinity, '');
  vis[sr][sc] = true;
  for(let d = 0; d < dir.length; d++) {
    let r = sr + dir[d][0];
    let c = sc + dir[d][1];
    if(r >=0 && c >=0 && r<=er && c<=ec && !vis[r][c]) {
      let recAns = shortestPathRecu(r, c, er, ec, vis, dir, dirS);

      if(recAns.shortestPathLength+1 < myAns.shortestPathLength) {
        myAns.shortestPathLength = recAns.shortestPathLength+1;
        myAns.shortestPath = dirS[d] + recAns.shortestPath;
      }
    }
  }

  vis[sr][sc] = false;

  return myAns;
}

function showAns() {
  let vis = Array.from({ length: 3 }, () => Array(3).fill(false));
  let dir = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0]
  ];
  let dirS = ["R", "D", "L", "U"];
  return shortestPathRecu(0, 0, 2, 2, vis, dir, dirS);
}
// console.log(showAns());

/*------------------------------------------------------------------------------------- */

function ccPermutationInfi(arr, tar, ans) {
  if(tar === 0) {
    console.log(ans);
    return 1;
  }
  
  let count  = 0;
  
  for(let i = 0; i<arr.length; i++) {
    if(tar - arr[i] >= 0) {
      count += ccPermutationInfi(arr, tar - arr[i], ans + arr[i]);
    }
  }
  
  return count;
}
// console.log(ccPermutationInfi([2,3,5,7], 10, ''));

/*------------------------------------------------------------------------------------- */

function ccCombinationInfi(arr, idx, tar, ans) {
  if(tar === 0) {
    console.log(ans);
    return 1;
  }
  
  let count  = 0;
  
  for(let i = idx; i<arr.length; i++) {
    if(tar - arr[i] >= 0) {
      count += ccCombinationInfi(arr, i, tar - arr[i], ans + arr[i]);
    }
  }
  
  return count;
}
// console.log(ccCombinationInfi([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

function ccCombinationSingle(arr, idx, tar, ans) {
  if(tar === 0) {
    console.log(ans);
    return 1;
  }
  
  let count  = 0;
  
  for(let i = idx; i<arr.length; i++) {
    if(tar - arr[i] >= 0) {
      count += ccCombinationSingle(arr, i+1, tar - arr[i], ans + arr[i]);
    }
  }
  
  return count;
}
// console.log(ccCombinationSingle([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

function ccPermutationSingle(arr, tar, ans) {
  if(tar === 0) {
    console.log(ans);
    return 1;
  }
  
  let count  = 0;
  
  for(let i = 0; i<arr.length; i++) {
    let ele = arr[i];
    if(tar - ele >= 0 &&  arr[i] > 0) {
      arr[i]  = -arr[i];
      count += ccPermutationSingle(arr, tar - ele, ans + ele);
      arr[i]  = -arr[i];
    }
  }
  
  return count;
}
// console.log(ccPermutationSingle([2,3,5,7], 10, ''));

/*------------------------------------------------------------------------------------- */

function ccPermutationInfiSubSeq(arr, idx, tar, ans) {
  if(arr.length === idx || tar ===0) {
    if(tar === 0 ){
      console.log(ans);
      return 1;
    }
    return 0;
  }
  
  let count  = 0;
  if(tar - arr[idx] >=0) {
    count += ccPermutationInfiSubSeq(arr, 0, tar - arr[idx], ans+arr[idx]);
  }
  count += ccPermutationInfiSubSeq(arr, idx+1, tar, ans);
  
  return count;
}
// console.log(ccPermutationInfiSubSeq([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

function ccCombinationInfiSubSeq(arr, idx, tar, ans) {
  if(arr.length === idx || tar ===0) {
    if(tar === 0 ){
      console.log(ans);
      return 1;
    }
    return 0;
  }
  
  let count  = 0;
  if(tar - arr[idx] >=0) {
    count += ccCombinationInfiSubSeq(arr, idx, tar - arr[idx], ans+arr[idx]);
  }
  count += ccCombinationInfiSubSeq(arr, idx+1, tar, ans);
  
  return count;
}
// console.log(ccCombinationInfiSubSeq([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

function ccCombinationSingleSubSeq(arr, idx, tar, ans) {
  if(arr.length === idx || tar ===0) {
    if(tar === 0 ){
      console.log(ans);
      return 1;
    }
    return 0;
  }
  
  let count  = 0;
  if(tar - arr[idx] >=0) {
    count += ccCombinationSingleSubSeq(arr, idx+1, tar - arr[idx], ans+arr[idx]);
  }
  count += ccCombinationSingleSubSeq(arr, idx+1, tar, ans);
  
  return count;
}
// console.log(ccCombinationSingleSubSeq([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

function ccPermutationSingleSubSeq(arr, idx, tar, ans) {
  if(arr.length === idx || tar ===0) {
    if(tar === 0 ){
      console.log(ans);
      return 1;
    }
    return 0;
  }
  
  let count  = 0;
  let ele = arr[idx];
  if(tar - ele >=0 && arr[idx] > 0) {
    arr[idx] = -arr[idx];
    count += ccPermutationSingleSubSeq(arr, 0, tar - ele, ans+ele);
    arr[idx] = -arr[idx];
  }
  count += ccPermutationSingleSubSeq(arr, idx+1, tar, ans);
  
  return count;
}
// console.log(ccPermutationSingleSubSeq([2,3,5,7], 0, 10, ''));

/*------------------------------------------------------------------------------------- */

//LC :-39
var combinationSum = function(arr, tar) {
  let res = [];
  let subRes = [];
  combinationInfisubSeq(arr, 0, tar, subRes, res);
  return res;
};

function combinationInfisubSeq(arr, idx, tar, subRes, res) {
  if(arr.length === idx || tar === 0) {
    if(tar === 0) {
      // console.log(subRes);
      res.push([...subRes]);
    }
    return;
  }


  if(tar - arr[idx] >= 0) {
    subRes.push(arr[idx]);
    combinationInfisubSeq(arr, idx, tar-arr[idx], subRes, res);
    subRes.pop();
  }
  combinationInfisubSeq(arr, idx+1, tar, subRes, res);
}

/*------------------------------------------------------------------------------------- */

//LC :- 40
var combinationSum2 = function(arr, tar) {
  let res =[];
  let subRes=[];
  arr.sort((a,b) => a-b);

  function combinationSingle(arr, idx, tar, subRes) {
  if(tar === 0) {
    res.push([...subRes]);
    return;
  }

  let prev = -1;

  for(let i = idx; i<arr.length; i++) {
    if(prev !== -1 && arr[prev] === arr[i]) continue;

    if(tar - arr[i] >= 0) {
      subRes.push(arr[i]);
      combinationSingle(arr, i+1, tar-arr[i], subRes);
      subRes.pop();
    }
    prev = i;
  }
}
  combinationSingle(arr, 0, tar, subRes);
  return res;
};

/*------------------------------------------------------------------------------------- */

//LC :- 46

var permute = function(nums) {
  let res = [];
  let subRes = [];

  function dfs( count, vis) {
    if(count === nums.length) {
      res.push([...subRes]);
      return;
    }

    for(let i = 0; i<nums.length; i++) {
      if(!vis[i]) {
        vis[i] = true;
        subRes.push(nums[i]);
        dfs(count+1, vis);
        subRes.pop();
        vis[i] = false;
      }
    }
  }

  let vis = Array(nums.length).fill(false);
  dfs(0, vis);
  return res;
};


/*------------------------------------------------------------------------------------- */

//LC :- 47

var permuteUnique = function(nums) {
  let res = [];
  let subRes = [];
  nums.sort((a,b) => a-b);

  function dfs(count, vis) {
    if(count === nums.length) {
      res.push([...subRes]);
      return; 
    }
    
    let prev = -1;
    for(let i =0; i<nums.length; i++) {
      if(prev !=-1 && nums[prev] === nums[i] ) continue;

      if(!vis[i]) {
        vis[i] = true;
        subRes.push(nums[i]);
        dfs(count+1, vis);
        subRes.pop();
        vis[i] = false;
        prev = i;
      }
    }
  }

  let vis = Array(nums.length).fill(false);
  dfs(0, vis);
  return res;
};

/*------------------------------------------------------------------------------------- */

//LC :- 216
var combinationSum3 = function(k, n) {
  let res = [];
  let subRes = [];

  function dfs(idx, tar) {
    if(tar === 0 && subRes.length === k) {
      res.push([...subRes]);
      return;
    }

    for(let i = idx; i <=9; i++) {
      if(tar - i >= 0) {
        subRes.push(i);
        dfs(i+1, tar-i);
        subRes.pop();
      }
    }
  }

  dfs(1, n);
  return res;
};

/*------------------------------------------------------------------------------------- */

//LC :- 77
var combine = function(n, k) {
  let res = [];
  let subRes = []

  function dfs(idx, count){
    if(count === k) {
      res.push([...subRes]);
      return;
    }
    for(let i = idx; i<=n; i++) {
      subRes.push(i);
      dfs(i+1, count+1);
      subRes.pop();
    }
  };

  dfs(1, 0);
  return res;
};

/*------------------------------------------------------------------------------------- */

//n queens questions start

// tnq : total no. of queen, qpsf : queen placed so far
// tnb : total no. of boxes,  bno: box no.

function queenCombination1D (tnb, bno, tnq, qpsf, ans) {
  if(tnq === qpsf) {
    console.log(ans);
    return 1;
  }
  
  let count = 0;
  
  for(let b = bno; b<tnb; b++) {
    count += queenCombination1D(tnb, b+1, tnq, qpsf+1, ans+"b"+b+"q"+qpsf+" ")
  }
  
  return count;
}

// console.log(queenCombination1D(5, 0, 3, 0, ''));

/*
Output:

b0q0 b1q1 b2q2 
b0q0 b1q1 b3q2 
b0q0 b1q1 b4q2 
b0q0 b2q1 b3q2 
b0q0 b2q1 b4q2 
b0q0 b3q1 b4q2 
b1q0 b2q1 b3q2 
b1q0 b2q1 b4q2 
b1q0 b3q1 b4q2 
b2q0 b3q1 b4q2 
10
*/


/*------------------------------------------------------------------------------------- */

function queenPermutaion1D(tnb, tnq, qpsf, ans) {
  if(tnq === qpsf) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  
  for(let b = 0; b < tnb.length; b++){
    if(!tnb[b]){
      tnb[b] = true;
      count += queenPermutaion1D(tnb, tnq, qpsf+1, ans+'b'+b+'q'+qpsf+' ');
      tnb[b] = false;
    }
    
  }

  return count;
};

// let tnb = Array(5).fill(false);
// console.log(queenPermutaion1D(tnb,3, 0, ''));  
//o/p - 60

/*------------------------------------------------------------------------------------- */

function queenCombination2D(tnb, idx, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  let n = tnb.length;
  let m = tnb[0].length;

  for( let i = idx; i < n * m; i++) {
    let r = Math.floor(i / m);
    let c = i % m;
    count += queenCombination2D(tnb, i+1, tnq-1, ans+'('+r+', '+c+') ');
  }
  return count;
};

// let tnb = new Array(4).fill().map(() => new Array(4).fill(false));
// console.log(queenCombination2D(tnb, 0, 4, ''));

/*------------------------------------------------------------------------------------- */


function queenPermutaion2D(tnb, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  let n = tnb.length;
  let m = tnb[0].length;

  for( let i = 0; i < n * m; i++) {
    let r = Math.floor(i / m);
    let c = i % m;
    if(!tnb[r][c]) {
      tnb[r][c] = true;
      count += queenPermutaion2D(tnb, tnq-1, ans+'('+r+', '+c+') ');
      tnb[r][c] = false;
    }
  }
  return count;
};

// let tnb = Array.from({ length: 4 }, () => Array(4).fill(false));
// console.log(tnb)
// console.log(queenPermutaion2D(tnb, 4, ''));

/*------------------------------------------------------------------------------------- */

function isSafeToPlaceQueen(boxes, r, c) {
  let dir = [ [0,-1], [-1,-1], [-1,0], [-1,1] ];
  for(let d = 0; d<dir.length; d++) {
    for(let rad = 1; rad<boxes.length; rad++) {
      let x = r + rad * dir[d][0];
      let y = c + rad * dir[d][1];

      if( x >= 0 && y >= 0 && x < boxes.length && y < boxes[0].length) {
        if(boxes[x][y]){
          return false;
        }
      } else {
        break;
      }
    }
  }

  return true;
};

function NQueenCombination(boxes, idx, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1;
  }

  let count = 0 ;
  let n = boxes.length;
  let m = boxes[0].length;

  for(let i = idx; i < m*n; i++) {
    let r = Math.floor(i/m);
    let c = i%m;
    if(isSafeToPlaceQueen(boxes, r, c)) {
      boxes[r][c] = true;
      count += NQueenCombination(boxes, i+1, tnq-1, ans+'('+r+', '+c+') ');
      boxes[r][c] = false;
    }
  }

  return count;
};


// let boxes = Array(4).fill().map(() => Array(4).fill(false));
// console.log(NQueenCombination(boxes, 0, 4, ''));

/*------------------------------------------------------------------------------------- */

function toggleNQueen(r, c, n) {
  rowArray[r] = !rowArray[r];
  colArray[c] = !colArray[c];
  diagArray[r-c+n-1] = !diagArray[r-c+n-1];
  antiDiagArray[r+c] = !antiDiagArray[r+c];
}

function NQueen2(n, idx, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  for(let i = idx; i<n*n; i++) {
    let r = Math.floor(i/n);
    let c = i%n;
    if(!rowArray[r] && !colArray[c] && !diagArray[r-c+n-1] && !antiDiagArray[r+c]) {
      toggleNQueen(r, c, n);
      count += NQueen2(n, i+1, tnq-1, ans+'('+r+', '+c+') ');
      toggleNQueen(r, c, n);
    }
  }
  return count;
}

// let n = 4;
// let rowArray = Array(n).fill(false);
// let colArray = Array(n).fill(false);
// let diagArray = Array(n + n -1).fill(false);
// let antiDiagArray = Array(n + n -1).fill(false);
// console.log(NQueen2(n, 0, n, ''));

/*------------------------------------------------------------------------------------- */

function toggleNQueen(r, c, n) {
  rowArray[r] = !rowArray[r];
  colArray[c] = !colArray[c];
  diagArray[r-c+n-1] = !diagArray[r-c+n-1];
  antiDiagArray[r+c] = !antiDiagArray[r+c];
}

function NQueen3_Permutation(boxes, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1;
  }

  let count = 0;
  let n = boxes.length;
  for(let i = 0; i<n*n; i++) {
    let r = Math.floor(i/n);
    let c = i%n;
    if(!boxes[r][c] && !rowArray[r] && !colArray[c] && !diagArray[r-c+n-1] && !antiDiagArray[r+c]) {
      boxes[r][c] = true;
      toggleNQueen(r, c, n);
      count += NQueen3_Permutation(boxes, tnq-1, ans+'('+r+', '+c+') ');
      toggleNQueen(r, c, n);
      boxes[r][c] = false;
    }
  }
  return count;
}

let n = 4;
let rowArray = Array(n).fill(false);
let colArray = Array(n).fill(false);
let diagArray = Array(n + n -1).fill(false);
let antiDiagArray = Array(n + n -1).fill(false);
// let boxes = Array(n).fill().map(() => Array(n).fill(false));
// console.log(NQueen3_Permutation(boxes, n, ''));

/*-------------------------------------------------------------------------------------*/

//nQueen 4c4 optimised
function nQueen4(n, r, tnq, ans) {
  if(tnq === 0) {
    console.log(ans);
    return 1; 
  }

  let count = 0;
  for(let c =0; c < n; c++) {
    if(!rowArray[r] && !colArray[c] && !diagArray[r-c+n-1] && !antiDiagArray[r+c]) {
      toggleNQueen(r,c,n);
      count += nQueen4(n, r+1, tnq-1, ans+'('+r+', '+c+') ');
      toggleNQueen(r,c,n);
    }
  }

  return count;
}

// console.log(nQueen4(n, 0, n, ''));

/*-------------------------------------------------------------------------------------*/
// 52. N-Queens II same as above question nqueen4

var totalNQueens = function(n) {
  let colArr = Array(n).fill(false);
  let dia = Array(n+n-1).fill(false);
  let aDia = Array(n+n-1).fill(false);

  function nQueen(n, r, tnq) {
      if(tnq === 0) {
          return 1;
      }

      let count = 0;
      for(let c =0; c < n; c++) {
          if(!colArr[c] && !dia[r-c+n-1] && !aDia[r+c]) {
              toggleQueen(r,c,n);
              count += nQueen(n, r+1, tnq-1);
              toggleQueen(r,c,n);
          }
      }
      return count;
  }

  function toggleQueen(r, c, n) {
      colArr[c] = !colArr[c];
      dia[r-c+n-1] = !dia[r-c+n-1];
      aDia[r+c] = !aDia[r+c];
  }

  return nQueen(n, 0, n);
};

/*-------------------------------------------------------------------------------------*/

// LC 191. Number of 1 Bits
var hammingWeight = function(n) {
  let count = 0;
  for(let i =0; i<32; i++) {
      let mask = (1 << i)
      if((n & mask) != 0) count ++;
  }
  return count;
};

