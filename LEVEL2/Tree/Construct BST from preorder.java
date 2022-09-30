import java.util.Scanner;

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
    
    public static int idx = 0;
    
    public static TreeNode build(int[] pre, int n, int lr, int rr){
        if(idx == n || pre[idx]<lr || pre[idx]>rr){
            return null;
        }

        TreeNode root = new TreeNode(pre[idx]);

        idx++;

        root.left = build(pre, n, lr, root.val);
        root.right  = build(pre, n, root.val, rr);

        return root;
    }

    public static TreeNode bstFromPreorder(int[] pre) {
        int n = pre.length;

        int lr = -(int)1e9-1;
        int rr =  (int)1e9+1;

        return build(pre, n, lr, rr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}