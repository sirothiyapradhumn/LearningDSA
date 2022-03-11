import java.util.*;

public class Main {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("hello");

    sb.append('e');
    sb.append('b');

    System.out.println(sb); 

    char ch = sb.charAt(3);
    System.out.println(ch);

    sb.setCharAt(3, 'z');
    System.out.println(sb);

    sb.deleteCharAt(5);
    System.out.println(sb);

    sb.insert(5, 'U');
    System.out.println(sb);

  }
}

/*    o/p

helloeb
l
helzoeb
helzob
helzoUb
*/