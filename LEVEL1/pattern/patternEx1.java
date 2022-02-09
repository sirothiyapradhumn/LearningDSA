import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    for(int i = 1; i<=n; i++){
      int val = 1;
      for(int j = 1; j<=n; j++){
        
        if((i==1) && ((j>=n/2+1 && j<=n) || j==1)){
          System.out.print(val+"\t");
          val++;
        }
        else if((i>1 && i<=n/2) && (j==1 || j== n/2+1)){
          System.out.print(val+"\t");
          val++;
        }
        else if( i==n/2+1){
          System.out.print(val+"\t");
          val++;
        }
        else if((i>=n/2+1 && i<n) && (j==n/2+1 || j==n)){
          System.out.print(val+"\t");
          val++;
        }
        else if((i==n) && ((j>=1 && j<=n/2+1)|| j==n)){
          System.out.print(val+"\t");
          val++;
        }
        else {
          System.out.print("\t");
        }
      }
      System.out.println();
    }

  }
}

/*
1		2	3	4	
1		2			
1	2	3	4	5	
		1		2	
1	2	3		4	
*/
