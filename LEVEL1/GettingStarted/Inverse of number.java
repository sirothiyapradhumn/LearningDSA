import java.util.*;

public class Main{

public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  int count = 1;
  int inverse = 0;
  while(n!=0){  
      int rem = n % 10;
      int po = (int)Math.pow(10,rem-1);
      inverse += count * po;

      n /= 10;
      count++;
  }
  System.out.println(inverse);
 }
}