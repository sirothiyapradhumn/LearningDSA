import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    boolean used[] = new boolean [ustr.length()];

    word2(ustr, 0, k, used, "");
  }

  public static void word2(String ustr, int cs, int ts, boolean [] used, String asf) {
    
    if(cs == ts){
      System.out.println(asf);
      return;
    }

    for(int i =0; i<ustr.length(); i++){
      char ch = ustr.charAt(i);

      if(used[i] == false){
        used[i] = true;
        word2(ustr, cs+1, ts, used, asf+ch);
        used[i] = false;
      }
    }
  }
}