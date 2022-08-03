// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean isOptionValid(int [][]board, int i, int j, int val){

    //row check
    for(int k = 0; k<9; k++){
      if(board[i][k] == val){
        return false;
      }
    }

    //col check
    for(int k = 0; k<9; k++){
      if(board[k][j] == val){
        return false;
      }
    }

    //grid 3*3
    i = i/3*3;
    j = j/3*3;

    for(int k =0; k<3; k++){
      for(int l = 0; l<3; l++){
        if(board[i+k][j+l] == val){
          return false;
        }
      }
    }


    return true;

  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    
    //for change row
    if(j==9){
      j =0; 
      i++;
    }

    if(i == 9){
      display(board);
      return;
    }


    if(board[i][j] != 0){
      solveSudoku(board, i , j+1);
    }
    else{
      for(int val = 1; val<=9; val++){
        if(isOptionValid(board, i, j, val) == true){
          board[i][j] = val;
          solveSudoku(board, i, j+1);
          board[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
