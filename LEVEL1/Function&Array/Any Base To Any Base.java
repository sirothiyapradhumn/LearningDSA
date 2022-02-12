import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sourceBase = scn.nextInt();
    int destBase = scn.nextInt();
    int deciVal = baseTodecimal(n, sourceBase);
    int baseVal = decimalToAnyBase(deciVal, destBase);
    System.out.println(baseVal);
   }   

  public static int baseTodecimal(int n, int sourceBase){
    int sum = 0;
    int count = 0;
    while(n!=0){
      int rem = n % 10;
      int po = (int)Math.pow(sourceBase, count);
      sum += rem * po;
      count++;
      n /= 10;
    }
    return sum;
  }

  public static int decimalToAnyBase(int deciVal, int destBase){
    int sum = 0;
    int count = 0;
    while(deciVal !=0){
      int rem = deciVal % destBase;
      int po = (int)Math.pow(10, count);
      sum += rem * po;
      count++;
      deciVal /= destBase;
    }
    return sum;
  } 

  }