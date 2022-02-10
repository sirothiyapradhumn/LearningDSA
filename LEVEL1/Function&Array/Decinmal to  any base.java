import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       
       int sum = 0;
       int count = 0;
       while(n!=0){
           int rem = n % b;
           int po = (int)Math.pow(10, count);
           count++;
           sum = (rem * po) + sum;
           n = n / b; 
       }

       return sum;
   }
  }