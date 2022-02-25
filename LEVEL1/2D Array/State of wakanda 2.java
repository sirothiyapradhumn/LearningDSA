import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = scn.nextInt();
            }
        }


        // dig = diagonals
        for(int dig = 0; dig<n; dig++){

            int i = 0;
            int j = dig;
            while(i<n && j <n){
                System.out.println(arr[i][j]);
                i++;
                j++;
            }
        }
    }

}