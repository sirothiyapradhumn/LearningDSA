import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {

      //syntax
      Stack<Integer> st = new Stack<>();

      //push-> 
      st.push(10);
      st.push(20);
      st.push(30);
      st.push(40);
      st.push(50);
      st.push(60);
      st.push(70);

      //size
      int size = st.size();
      //size before poping
      System.out.println("Size of stack before pop " +size);

      while(st.size()>0){
         System.out.println(st.pop());
      }

      size = st.size();

      System.out.println("Size of stack after pop " + size);
   }
}