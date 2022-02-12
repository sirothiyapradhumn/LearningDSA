import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
     int sum = 0;
     int count = 0;
     while(n!=0){
       int rem = n % 10;
       int po = (int)Math.pow(b, count);
       sum = (rem * po) + sum;
       count++;
       n = n / 10;
     }
     
     return sum;
   }
  }

 