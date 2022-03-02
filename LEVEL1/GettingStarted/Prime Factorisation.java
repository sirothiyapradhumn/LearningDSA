import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here 
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();

  // //not optimise 
  // for(int div = 2; div<=n; div++){
  //     while(n % div == 0){
  //       n = n/div;
  //       System.out.print(div+" ");
  //     }
  // }

  // optimise
   for(int div = 2; div*div<=n; div++){
      while(n % div == 0){
        n = n/div;
        System.out.print(div+" ");
      }
  }
  // in case agar 1 sai jyada remender rhe jata hai uskai liye
  if(n!=1){
    System.err.print(n);
  }
   
 }
}  