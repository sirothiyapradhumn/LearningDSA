import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    HashMap <Integer, Boolean> map = new HashMap<>();

    int[] a = new int[n];

    // consider all element as a SP
    for(int i = 0; i<n; i++){
        a[i] = scn.nextInt();
        map.put(a[i], true);
    }

    //discard invalid SP
    for(int i =0; i<n; i++){
        if(map.containsKey(a[i]-1) == true){
            map.put(a[i], false);
        }
    }

    //System.out.println(map);

    int sp = 0;
    int maxLength = 0;

    for(int i=0; i<n; i++){
        if(map.get(a[i]) == true){
            int curr = a[i];
            int len = 1;
            while(map.containsKey(curr+1) == true){
                curr +=1;
                len++;
            }
            if(len>maxLength){
                maxLength = len;
                sp = a[i];
            }
        }
    }

    for(int i =0; i<maxLength; i++){
        System.out.println(sp+i);
    }

    
 }

}