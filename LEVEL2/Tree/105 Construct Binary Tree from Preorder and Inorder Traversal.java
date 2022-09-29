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
    
    public TreeNode build(int[] pre, int psi, int pei, int[] in, int insi, int inei){
        
        if(insi>inei) return null;
        
        TreeNode root = new TreeNode(pre[psi]);
        
        int idx = insi;
        
        while(pre[psi] != in[idx]){
            idx++;
        }
        
        int non = idx - insi;
        
        root.left = build(pre, psi+1, psi+non, in, insi, idx-1);
        root.right = build(pre, psi+non+1, pei, in, idx+1, inei);
        
        return root;
    }
    
    public TreeNode buildTree(int[] pre, int[] in) {
          return build(pre, 0, pre.length-1, in, 0, in.length-1);
    }
}