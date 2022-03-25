import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
         
        printSS(str, "");
             // (str, ansSoFar)
    }

    public static void printSS(String str, String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        //include
        printSS(ros, asf+ch);

        //exclude
        printSS(ros, asf);
    }

}