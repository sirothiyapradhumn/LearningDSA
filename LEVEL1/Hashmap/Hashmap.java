import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 222);
        map.put("Usa", 90);
        map.put("Uk", 110);
        map.put("INdia", 333);

        System.out.println(map); 
        //{Usa=90, Uk=110, India=222}


        //containsKey
        if(map.containsKey("India") == true){
            System.out.println("Lets Go !!!!");
        }

        if(map.containsKey("InDia") == true){
            System.out.println("Lets Go !!!!");
        }
        else{
            System.out.println("Not found !!");
        }

        //remove
        map.remove("INdia");
        System.out.println(map);
        map.remove("INdIa"); // will do nothing bcoz key is not present in map

        //get 
        System.out.println(map.get("Usa"));
        System.out.println(map.get("China")); //null -> not present in map

        //getOrDefault
        System.out.println(map.getOrDefault("China", 0)); //key china not present in map so it use default value
        
        System.out.println(map.getOrDefault("Usa", 0));// 90

        //size
        System.out.println(map.size()); //3

        //keySet

        ArrayList<String> al = new ArrayList<>(map.keySet()); 
        System.out.println(al); //[Usa, Uk, India]
        

    }

}