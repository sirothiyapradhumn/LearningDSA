import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans); 
        
        }

    public static ArrayList<String> getStairPaths(int n) {
        //+ve base case 
        if(n==0){
            ArrayList<String> Base1 = new ArrayList<>();
            Base1.add("");
            return Base1;
        }

        //-ve base case 
        if(n<0){
            ArrayList<String> Base2 = new ArrayList<>();
            return Base2;
        }

        //faith 1
        ArrayList<String> rr1 = getStairPaths(n-1);
        //faith 2
        ArrayList<String> rr2 = getStairPaths(n-2);
        //faith 3
        ArrayList<String> rr3 = getStairPaths(n-3);


        //mywork
        ArrayList<String> myAns = new ArrayList<>();

        for(int i =0; i<rr1.size(); i++){
            myAns.add("1"+rr1.get(i));
        }

        for(int i =0; i<rr2.size(); i++){
            myAns.add("2"+rr2.get(i));
        }

        for(int i =0; i<rr3.size(); i++){
            myAns.add("3"+rr3.get(i));
        }

        return myAns;

    }

}