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
    public boolean helper(TreeNode root, int targetSum, int asf){
        
        
        if(root == null) return false;
        
        if(root.left == null && root.right == null){
            asf += root.val;
            if(asf == targetSum) return true;
        }
        
        boolean leftSide = helper(root.left, targetSum, asf+root.val);
        boolean rightSide = helper(root.right, targetSum, asf+root.val);
        
        return leftSide || rightSide;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root == null) return false;
        
//         if(root.left == null && root.right == null){
//             if(targetSum == root.val) return true;
//         }
        
//         boolean leftSide = hasPathSum(root.left, targetSum-root.val);
//         boolean rightSide = hasPathSum(root.right, targetSum-root.val);
        
//         return leftSide || rightSide;
        
        boolean ans = helper(root, targetSum, 0);
        
        return ans;
    }
}