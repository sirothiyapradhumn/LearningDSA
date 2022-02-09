import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=n; j++){

            if( (i==1) && ((j>=1 && j<=n/2+1) || (j==n))){  // first row
                System.out.print("*\t");
            }
            else if( (i>1 && i<=n/2+1) && (j==n/2+1 || j==n) ){ // first > row < middle -1
                System.out.print("*\t");
            }
            else if( i == n/2+1){ // middle row
                System.out.print("*\t");
            }
            else if((i>n/2+1 && i<n) && (j==1 || j==n/2+1)){  //middle +1 > row < n-1
                System.out.print("*\t");
            }
            else if((i==n) && (j==1 || (j>=n/2+1 && j<=n))){ // last row
                System.out.print("*\t");
            }
            else {
                System.out.print("\t");
            }
        
    }
    System.out.println();
 }
}
}


// by nested if

import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=n; j++){

        //first row 
        if(i == 1){
            if( j>=1 && j<= n/2 +1 || (j==n)){
                System.out.print("*\t");
            }
            else {
                System.out.print("\t");
            }
        }

        //2 row -> middle -1 
        if(i>1 && i<=n/2){
            if(j == n/2 +1 || j == n){
                System.out.print("*\t");
            }
            else {
                System.out.print("\t");
            }
        }

        //middle row
        if(i == n/2 +1){
            System.out.print("*\t");
        }

        // middle row +1 -> n-1
        if(i > n/2 +1 && i < n){
            if( j==1 || j==n/2+1){
                System.out.print("*\t");
            }
            else {
                System.out.print("\t");
            }
        }

        //last row
        if(i == n){
            if( j==1 || (j>=n/2+1 && j<=n)){
                System.out.print("*\t");
            }
            else {
                System.out.print("\t");
            }
        }
    }
    System.out.println();
 }
}
}