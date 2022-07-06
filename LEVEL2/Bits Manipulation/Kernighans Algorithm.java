import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int count = 0;

    while(n!=0){ // n!=0 --- bcoz of -ve no.s
      
      int rsbm = ~(n&(-n));
      count++;
      n = n&rsbm;
    }

    System.out.println(count);
  }

}