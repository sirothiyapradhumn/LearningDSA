import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(1, 1, n, m);
        System.out.println(ans);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        //-ve base case 
        if(sc>dc || sr>dr){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        //+ve base case 
        if(sc==dc && sr==dr){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        //faith
        ArrayList<String> rr1 = getMazePaths(sr, sc+1, dr, dc);
        ArrayList<String> rr2 = getMazePaths(sr+1, sc, dr, dc);


        //myWork
        ArrayList<String> myAns = new ArrayList<>();

        for(int i =0; i<rr1.size(); i++){
            myAns.add("h"+rr1.get(i));
        }

        for(int i =0; i<rr2.size(); i++){
            myAns.add("v"+rr2.get(i));
        }

        return myAns;
    }

}
##################################################################################################################################

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, n-1, m-1);
        System.out.println(ans);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        //+ve Basse case 
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        //fatih
        ArrayList<String> rr1 = new ArrayList<>();
        ArrayList<String> rr2 = new ArrayList<>();

        if(sc<dc){
           // horizontal move if col wall is stops
           rr1 = getMazePaths(sr, sc+1, dr, dc);
        }
        
        if(sr<dr){
           //vertical move if row wall is stops
           rr2 = getMazePaths(sr+1, sc, dr, dc);
        }
        

        //my work

        ArrayList<String> myAns = new ArrayList<String>();

        for(int i=0; i<rr1.size(); i++){
            myAns.add("h"+rr1.get(i));
        }

        for(int i=0; i<rr2.size(); i++){
            myAns.add("v"+rr2.get(i));
        }

        return myAns;
    }

}