import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        // 0-> east, 1-> south, 2-> west, 3->north
        int dir = 0;

        //entry point
        int i = 0;
        int j = 0;

        while(true){


            dir = (dir + arr[i][j]) % 4;

            if(dir == 0){ //east
                j++;
            }
            else if(dir == 1){ // south
                i++;
            }
            else if( dir == 2){ // west
                j--;
            }
            else if(dir == 3){ // north
                i--;
            }


            if(i<0){  // i goes -ve
                i++;
                break;
            }
            else if(j<0){ // j goes -ve
                j++; 
                break;
            }
            else if( i == arr.length){ // i goes out of  wall
                i--;
                break;
            }
            else if( j == arr[0].length){ // j goes out of wall
                j--;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);
    }

}