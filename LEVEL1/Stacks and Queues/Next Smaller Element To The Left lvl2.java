import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
    // solve
    int n = arr.length;
    int ans[] = new int[n];

    Stack<Integer> st = new Stack<>();

    st.push(arr[0]);
    ans[0] = -1;

    for(int i = 1; i<n; i++){
      //pop all the Greater element

      while(st.size()!=0 && arr[i]<st.peek()){
        st.pop();
      }

      //filling the ans[]
      if(st.size() == 0){
        ans[i] = -1;
      }
      else{
        ans[i] = st.peek();
      }

      //potentail value for next element
      st.push(arr[i]);
    } 
    return ans;
  }

}