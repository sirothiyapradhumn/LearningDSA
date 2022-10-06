import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static int helper(TreeNode root, int fireNode){
        if(root == null) return -1;
        
        if(root.val == fireNode){
            burnNodes(root, 0, null);
            return 1;
        }
        
        int ld = helper(root.left, fireNode);
        if(ld != -1){
            burnNodes(root, ld, root.left);
            return ld+1;
        }
        
        int rd = helper(root.right, fireNode);
        if(rd != -1){
            burnNodes(root, rd, root.right);
            return rd+1;
        }
        
        return -1;
    }
    
    public static void burnNodes(TreeNode root, int time, TreeNode blockage){
        if(root == null || root == blockage){
            return;
        }
        
        maxTime = Math.max(maxTime, time);
        
        burnNodes(root.left, time+1, blockage);
        
        burnNodes(root.right, time+1, blockage);
        
    }

  public static int maxTime = 0;  
  public static int burningTree(TreeNode root, int fireNode) {
      helper(root, fireNode);
        return maxTime;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}