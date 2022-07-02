import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        HashMap<Character, Integer> map = new HashMap<>();

        int maxFreq = 0;
        char maxFreqChar = 'a';

        for(int i  = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) == true){
                int freq = map.get(ch);
                freq += 1;
                map.put(ch, freq);
            }
            else{
                map.put(ch, 1);
            }

            if(map.get(ch) > maxFreq){
                maxFreq = map.get(ch);
                maxFreqChar = ch;
            }
        }

        System.out.println(maxFreqChar);
    }

}