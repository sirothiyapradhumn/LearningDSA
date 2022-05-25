import java.io.*;
import java.util.*;

public class Main {

  public static class Node{
    int data;
    ArrayList<Node> children;

    Node(int data){
      this.data = data;
      children = new ArrayList<>();
    }
  }

  public static void display(Node node){

    String str = node.data+" -> ";
    for(Node child : node.children){
      str+=child.data+", ";
    }

    str += " .";

    System.out.println(str);

    //faith
    for(Node child: node.children){
      display(child);
    }

    // for(int i = 0; i<node.children.size(); i++){
    //   Node child = node.children.get(i);
    //   display(child);
    // }
  }

  public static Node construct(int[] arr){
    Stack<Node> st = new Stack<>();
    Node root = new Node(arr[0]);

    st.push(root);
    for(int i = 1; i<arr.length; i++){
        if(arr[i] == -1){
          st.pop();
        }
        else{
          Node nn = new Node(arr[i]);
          st.peek().children.add(nn);
          //10k.children mai add kar do

          st.push(nn);

        }
    }
    return root;
  }

  public static void main(String[] args){
    int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    Node root = construct(arr);
    display(root);
  }
}

/* o/p
10 -> 20, 30, 40,  .
20 -> 50, 60,  .
50 ->  .
60 ->  .
30 -> 70, 80, 90,  .
70 ->  .
80 -> 110, 120,  .
110 ->  .
120 ->  .
90 ->  .
40 -> 100,  .
100 ->  .

*/
