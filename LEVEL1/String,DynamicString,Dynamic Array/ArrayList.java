import java.util.*;

public class Main {

  public static void main(String[] args) {
  
  ArrayList<Integer> al = new ArrayList<>();

  //add
  al.add(10);
  al.add(20);
  al.add(30);
  al.add(40);
  al.add(50);

  System.out.println(al);
  System.out.println(al.size());
  System.out.println(al.get(2));
  
  //set
  al.set(3, 500);
  System.out.println(al);

  // insert
  al.add(2, 100);
  System.out.println(al);

  // remove
  al.remove(2);
  System.out.println(al);


  }
}

/* 
//   o/p

[10, 20, 30, 40, 50]
5
30
[10, 20, 30, 500, 50]
[10, 20, 100, 30, 500, 50]
[10, 20, 30, 500, 50]


*/