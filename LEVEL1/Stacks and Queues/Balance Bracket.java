import java.io.*;
import java.util.*;

public class Main {

    public static boolean check(Stack<Character>st, char bracket){
            //less opening bracket
             if(st.size() == 0){
                return false;
             }
             //mismatch
             else if(st.peek()!= bracket){
               return false;
             }
             else {
                st.pop();
                return true;
             }
    }

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       String exp = scn.nextLine();

       Stack <Character> st = new Stack<> ();

       for(int i =0; i<exp.length(); i++){
          char ch = exp.charAt(i);

          //opeaning bracket
          if( ch == '{' || ch == '[' || ch == '('){
             st.push(ch);
          }

          //closing bracket
          else if( ch == ')'){
             
             boolean ans = check(st, '(');

             if(ans == false){
                System.out.println(false);
                return;
             }
          }
          else if(ch == ']'){

             boolean ans = check(st, '[');
             if(ans == false){
                System.out.println(false);
                return;
             }
          }
          else if(ch == '}'){
             boolean ans = check(st, '{');

             if(ans == false){
                System.out.println(false);
                return;
             }
          }
       }
       if(st.size()==0){
          System.out.println(true);
       }
       else{
          System.out.println(false);
       }
    }

}