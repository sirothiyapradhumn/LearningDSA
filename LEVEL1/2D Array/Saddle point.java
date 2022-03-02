import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for( int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();  
            }
        }

        // find min element in nth row and find its column no.
        for(int i =0; i<n; i++){
            int min = arr[i][0];
            int colNo = 0;

            for(int col = 0; col<n; col++){
                if(min > arr[i][col]){
                    min = arr[i][col];
                    colNo = col;
                }
            }

            // verification
            boolean ans = true;
            
            for(int row = 0; row<n; row++){
                if( min < arr[row][colNo]){
                    ans = false;
                    break;
                }
            }

            if(ans == true){
                System.out.println(min);
                return;
            }
        }

        System.out.println("Invalid input");
    }

}