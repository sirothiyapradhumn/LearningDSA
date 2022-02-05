import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nst = 1;
    int nsp = 2*n - 3;
    
    for(int i = 1; i<=n; i++){

        for(int j = 1; j<=nst; j++){
            System.out.print(j+"\t");
        }

        for(int k = 1; k<=nsp; k++){
            System.out.print("\t");
        }


        if(i == n) nst--; 
        for(int j = nst; j>=1; j--){
            System.out.print(j+"\t");
                
        }

        System.out.println();
        
        nst++;
        nsp -=2; 
    }

 }
}

/* 
1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1
*/