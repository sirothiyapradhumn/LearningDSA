/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode LCA = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean LCAofTree = helper(root, p, q);
        return LCA;
    }
    
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        
        boolean self = (root == p || root == q) ? true:false;
        
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        
        if((left && right) || (left && self) || (right && self)){
            LCA = root;
        }
        
        return self || left || right;
    }
    
}