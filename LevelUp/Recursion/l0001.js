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
