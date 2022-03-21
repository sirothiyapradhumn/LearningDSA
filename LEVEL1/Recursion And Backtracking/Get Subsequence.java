import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ans = gss(str);

        System.out.println(ans);
    }

    public static ArrayList<String> gss(String str) {

        //base condition
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        char ch = str.charAt(0);
        String ros = str.substring(1);

        //Faith
        ArrayList<String> rr = gss(ros);

        //my work
        ArrayList<String> myans = new ArrayList<String>();

        //1.1 exclude 
        for(int i = 0; i<rr.size(); i++){
            myans.add(rr.get(i));
        }

        //1.2 include
        for(int i = 0; i<rr.size(); i++){
            myans.add(ch+rr.get(i));
        }

        return myans;
    }

}