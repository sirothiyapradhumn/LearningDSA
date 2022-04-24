import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int arr[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j <n; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        // 1st step -> transposing the matrix
        transpose(arr);
        // 2nd step -> reverse Single row
        rotateSingleRow(arr);
        // 3rd display
        display(arr);
        
    }

    public static void transpose(int arr[][]){

        for(int i = 0; i<arr.length-1; i++){
            for(int j = i+1; j<arr[0].length; j++){
                swap(arr, i , j);
            }
        }
    }

    public static void rotateSingleRow(int arr[][]){
        for(int i = 0; i<arr.length; i++){
            int left = 0;
            int right = arr[0].length -1;

            while(left<right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;

                left++;
                right--;
            }
        }
    } 

    public static void swap(int arr[][] , int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}