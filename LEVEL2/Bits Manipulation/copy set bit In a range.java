import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

   //write your code here

   int mask = a & (((1<<(right-left+1))-1)<<(left-1));

   int ans = b|mask;

   System.out.println(ans);
    
  }

}