import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int count = 0;
       int ans = 0;
       int borrow = 0;
       while(n2!=0){
           int rem1 = n1 % 10;
           int rem2 = n2 % 10;
           int diff = rem2 - rem1 - borrow;
           if(diff<0){
               borrow = 1;
               diff = b + diff;
           }
           else{
               borrow = 0;
           }
           int po = (int)Math.pow(10, count);
           ans += diff * po;

           count++;
           n1 /=10;
           n2 /=10;
       }
       return ans;
   }
  
  }