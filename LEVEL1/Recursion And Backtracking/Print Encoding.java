import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {

        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        
        //step 1
        String ch0 = str.substring(0,1);
        String ros = str.substring(1);

        //step 2 
        if(ch0.equals("0")) return;

        printEncodings(ros, asf+(char)(Integer.parseInt(ch0)-1+'a'));

        //step 3
        if(str.length()>=2){
            //step4
            String ch01 = str.substring(0,2);
            String ros2 = str.substring(2);

            //step5
            if(Integer.parseInt(ch01)<=26){
                printEncodings(ros2, asf+(char)(Integer.parseInt(ch01)-1+'a'));
            }
        }


    }

}