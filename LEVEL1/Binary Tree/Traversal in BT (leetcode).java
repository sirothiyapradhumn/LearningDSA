//144 - pre
//95 - In
//145 - post

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


// 144. Binary Tree Preorder Traversal 
class Solution {
    
    public void helper(TreeNode root, List<Integer>ans){
        //base case 
        if(root == null){
            return;
        }
        
        //my work
        ans.add(root.val);
        //left 
        helper(root.left, ans);
        //right
        helper(root.right, ans);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, ans);
        
        return ans;
    }
}



//94. Binary Tree Inorder Traversal
class Solution {
    public void helper(TreeNode root, List<Integer>ans){
        //base case 
        if(root == null){
            return;
        }
        
        
        //left 
        helper(root.left, ans);
        //my work
        ans.add(root.val);
        //right
        helper(root.right, ans);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, ans);
        
        return ans;
    }
}



//145. Binary Tree Postorder Traversal
class Solution {
    public void helper(TreeNode root, List<Integer>ans){
        //base case 
        if(root == null){
            return;
        }
        
        //left 
        helper(root.left, ans);
        //right
        helper(root.right, ans);
        //my work
        ans.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, ans);
        
        return ans;
    }
}