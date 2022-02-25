import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        // 1st step -> transposing the matrix
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // 2nd step -> reverse row

        for(int row = 0; row<n; row++){
            int left  = 0;
            int right = n-1;
            while(left < right){
                int temp  = arr[row][left];
                arr[row][left] = arr[row][right];
                arr[row][right] = temp;

                left++;
                right--;
            }

        }

        display(arr);
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