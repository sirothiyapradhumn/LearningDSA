import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str  = scn.nextLine();
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);

    }
    
    // strArr ko globle use karne kai liye
    static String[] strArr = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        
        // base condition
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        //faith
        ArrayList<String> rr = getKPC(ros);
        
        //my WOrk
            // code -> jkl, etc
        String code  = strArr[ch-'0'];

        ArrayList<String> myAns = new ArrayList<>();

        for(int i = 0; i<code.length(); i++){
            char c = code.charAt(i);
            for(int j = 0; j<rr.size(); j++){
                myAns.add(c + rr.get(j));
            }
        }

        return myAns;
        
    }

}