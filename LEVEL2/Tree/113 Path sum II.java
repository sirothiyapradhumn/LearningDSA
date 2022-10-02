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
    public void helper(TreeNode root, int targetSum, List<Integer>subAns, List<List<Integer>>ans){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                List<Integer> arr = new ArrayList<>(subAns);
                arr.add(root.val);
                ans.add(arr);
                return;
            }
        }
        
        subAns.add(root.val);
        
        helper(root.left, targetSum-root.val, subAns, ans);
        helper(root.right, targetSum-root.val, subAns, ans);
        
        subAns.remove(subAns.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        
        helper(root, targetSum, subAns, ans);
        
        return ans;
    }
}