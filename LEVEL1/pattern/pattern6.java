import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nst = (n+1)/2;
        int nsp = 1;

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=nst; j++){
                System.out.print("*\t");
            }
            for(int k = 1; k<=nsp; k++){
                System.out.print("\t");
            }
            for(int j = 1; j<=nst; j++){
                System.out.print("*\t");
            }

            if(i<=n/2){
                nst--;
                nsp = nsp + 2;
            }else{
                nst++;
                nsp = nsp - 2;
            }
            System.out.println();
        }

    }
}

/*

*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*	 

*/