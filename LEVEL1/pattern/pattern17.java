import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nst = 1;
        int nsp = n/2;

        for(int i = 1; i<=n; i++){
            // if(i != n/2 + 1){
            //     for(int j = 1; j<=nsp; j++){
            //         System.out.print("\t");
            //     }
            // }
            // else {
            //     for(int j = 1; j<=nsp; j++){
            //         System.out.print("*\t");
            //     }
            // }
            
            for(int j = 1; j<=nsp; j++){
                if(i == n/2 + 1){
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
                    
                }

            for(int j = 1; j<=nst; j++){
                System.out.print("*\t");
            }
            
            if(i<=n/2){
                nst++;
            }
            else {
                nst--;
            }

            System.out.println();
        }

    }
}