import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int rmin = 0;
        int rmax = n-1;
        int cmin = 0;
        int cmax = m-1;
        int count = 0;
        while(count < n*m){

            //left wall
            for(int row = rmin; row<=rmax && count < n*m; row++){
                System.out.println(arr[row][cmin]);
                count++;
            }
                // update value cmin  taki value repeate na ho 
                cmin++;

            //bottom wall
            for(int col = cmin; col<=cmax && count < n*m; col++){
                System.out.println(arr[rmax][col]);
                count++;
            }
                // update value rmax taki value repeate na ho 
                rmax--;

            //right wall
            for(int row = rmax; row>=rmin && count < n*m; row--){
                System.out.println(arr[row][cmax]);
                count++;
            }
                // update value cmax  taki value repeate na ho 
                cmax--;
            
            //top wall
            for(int col = cmax; col>=cmin && count < n*m; col--){
                System.out.println(arr[rmin][col]);
                count++;
            }
                // update value rmin taki value repeate na ho 
                rmin++;

        }
    }

}