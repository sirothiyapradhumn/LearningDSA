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
        int data = scn.nextInt();
        
        //top right
        int i = 0;
        int j = n-1;
        while(j>=0 && i<=n){
            if(data == arr[i][j]){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(data>arr[i][j]){
                i++;
            }else{
                j--;
            }
        }

        System.out.println("Not Found");
    }

}