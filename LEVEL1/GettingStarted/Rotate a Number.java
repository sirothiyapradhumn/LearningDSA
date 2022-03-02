import java.util.*;
import java.lang.Math;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
     int n = scn.nextInt();
     int k = scn.nextInt();

     int count = 0;
     int num = n; 
     while(num!=0){
       num = num / 10;
       count++;
     }
    
    // when k's value badi ho no of digit sai
     k = k % count;
     // jab k ki value -ve ho
     if( k < 0){
       k = k + count;
     }

     int div = (int)Math.pow(10,k);
     int rem = n % div; 
     int x = n / div; 
     int y = rem * (int)Math.pow(10,count-k);
     int z = y + x;
     System.out.println(z);   
     

    }
   }