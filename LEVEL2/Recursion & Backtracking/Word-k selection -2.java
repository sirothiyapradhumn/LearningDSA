import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

  selection(ustr, 0, k, "", -1);
  }


  public static void selection(String ustr, int cs, int ts, String asf, int lcu ) {

    if(cs == ts){
      System.out.println(asf);
      return;
    }

    for(int i = lcu+1; i<ustr.length(); i++){
      char ch = ustr.charAt(i);
      selection(ustr, cs+1, ts, asf+ch, i);
    }

  }

}