import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr){
       //write your code here

       int suMxor = 0;


    //  O(n2);
    //    for(int i =0; i<arr.length; i++){
    //        for(int j = 0; j<arr.length; j++){
    //            suMxor  ^= (arr[i]+arr[j]);
    //        }
    //    }
       

       for(int i =0; i<arr.length; i++){
           suMxor ^= (2*arr[i]);
       }

       return suMxor;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}