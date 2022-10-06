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

  public static void kLevelDown(TreeNode root, int k, TreeNode blockage, ArrayList<Integer>ans){
    if(root == null || k <0 || root==blockage){
      return;
    }

    if(k == 0){
      ans.add(root.val);
      return;
    }

    kLevelDown(root.left, k-1, blockage, ans);
    kLevelDown(root.right, k-1, blockage, ans);
  }
  public static int nodeToRoot(TreeNode root, int target, int k, ArrayList<Integer> ans){
    if(root == null) return -1;

    if(root.val == target){
      kLevelDown(root, k, null, ans);
      return 1;
    }

    int ld = nodeToRoot(root.left, target, k, ans);
    if(ld != -1){
      kLevelDown(root, k-ld, root.left, ans);
      return ld+1;
    }

    int rd = nodeToRoot(root.right, target, k, ans);
    if(rd != -1){
      kLevelDown(root, k-rd, root.right, ans);
      return rd+1;
    }

    return -1;
  }

  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    ArrayList<Integer> ans = new ArrayList<>();

    nodeToRoot(root, target, k, ans);

    return ans;
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}