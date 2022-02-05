import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nsp = n/2;
        int nst = 1;
        int oval = 1;

        for(int i = 1; i<=n; i++){
            int ival = oval;
            
            for(int j = 1; j<=nsp; j++ ){
                System.out.print("\t");
            }
            

            for(int k = 1; k<=nst; k++){
                if(k<=nst/2){
                    System.out.print(ival+"\t");
                    ival++;
                }
                else {
                    System.out.print(ival+"\t");
                    ival--;
                }

            }
            
            if(i <= n/2){
                nsp--;
                nst += 2;
                oval ++;
            }else{
                nsp++;
                nst -= 2;
                oval--;
            }
            System.out.println();
        }

    }
}

/* 
		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	
*/