import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int shell = scn.nextInt();
        int rotate = scn.nextInt();

        ringRotate(arr, shell, rotate);
        display(arr);


    }

    public static void ringRotate(int[][] arr, int shell, int rotate){

        // step 1 -> 1d array fill from 2d ring
        // la -> liniar array
        int[] la = fill1dFrom2d(arr, shell);

        //step 2 -> rotate 1d array 
        rotate1d(la, rotate);

        //step 3 fill 2d array with 1d
        fill2dfrom1d(arr, shell, la);        
    }

    //step 1
    public static int[] fill1dFrom2d(int[][] arr, int shell){
        int rmin = shell - 1;
        int cmin = shell - 1;
        int rmax = arr.length - shell;
        int cmax = arr[0].length - shell;

        int sz = 2*(rmax - rmin) + 2*(cmax - cmin);
        int[] la = new int[sz];
        int idx = 0;

        //left 
        for(int row = rmin; row<=rmax; row++){
            la[idx] = arr[row][cmin];
            idx++;
        }
        cmin++;

        //bottom
        for(int col = cmin; col<=cmax; col++){
            la[idx] = arr[rmax][col];
            idx++;
        }
        rmax--;

        //right
        for(int row = rmax; row>=rmin; row--){
            la[idx] = arr[row][cmax];
            idx++;
        }
        cmax--;

        //top
        for(int col = cmax; col>=cmin; col--){
            la[idx] = arr[rmin][col];
            idx++;
        }
        rmin++;

        return la;
    }
    
    //step 2
    public static void rotate1d(int []la, int r){
        r = r % la.length;
        if(r<0){
            r += la.length; 
        }

        reverse(la, 0, la.length-1);
        reverse(la, 0, r-1);
        reverse(la, r, la.length-1);
    }

    public static void reverse(int[] la, int left, int right) {

        while(left<right){
            int temp = la[left];
            la[left] = la[right];
            la[right] = temp;
            left++;
            right--;
        }
        
    }
    // step 3
    public static void fill2dfrom1d(int arr[][], int shell, int []la){
        int rmin = shell - 1;
        int cmin = shell - 1;
        int rmax = arr.length - shell;
        int cmax = arr[0].length - shell;

        
        int idx = 0;

        //left 
        for(int row = rmin; row<=rmax; row++){
            arr[row][cmin] = la[idx];
            idx++;
        }
        cmin++;

        //bottom
        for(int col = cmin; col<=cmax; col++){
            arr[rmax][col] = la[idx];
            idx++;
        }
        rmax--;

        //right
        for(int row = rmax; row>=rmin; row--){
            arr[row][cmax] = la[idx];
            idx++;
        }
        cmax--;

        //top
        for(int col = cmax; col>=cmin; col--){
            arr[rmin][col] = la[idx];
            idx++;
        }
        rmin++;

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