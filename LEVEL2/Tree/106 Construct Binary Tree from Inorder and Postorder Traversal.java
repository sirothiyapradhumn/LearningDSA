/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode build(int in[], int insi, int inei, int post[], int psi, int pei){
        if(insi > inei) return null;
        
        TreeNode root = new TreeNode(post[pei]);
        
        int idx = insi;
        
        while(post[pei] != in[idx]) idx++;
        
        int non = idx - insi;
        
        root.left = build(in, insi, idx-1, post, psi, psi+non-1);
        root.right = build(in, idx+1, inei, post, psi+non, pei-1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] in, int[] post) {
        return build(in, 0, in.length-1, post, 0, post.length-1);
    }
}