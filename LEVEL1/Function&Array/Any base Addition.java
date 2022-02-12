import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       int carry = 0;
       int ans = 0;
       int count = 0;
       while(n1!=0 || n2!=0 || carry!=0){
           int rem1 = n1 % 10;
           int rem2 = n2 % 10;
           int sum = rem1 + rem2 + carry;
           int check1 = sum % b;
           int check2 = sum / b;
           int po = (int)Math.pow(10, count);
           ans += check1 * po;
           carry = check2;
           count++;
           n1 /= 10;
           n2 /= 10;
       }
       return ans;
   }
  }