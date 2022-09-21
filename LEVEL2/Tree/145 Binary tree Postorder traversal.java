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
        // helper(root, ans);
        
        if(root == null) return ans;
        
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        
        st1.push(root);
        
        while(st1.size() != 0){
            
            TreeNode node = st1.pop();
            st2.push(node);
            
            if(node.left != null){
                st1.push(node.left);
            }
            
            if(node.right != null){
                st1.push(node.right);
            }
        }
        
        while(st2.size() != 0){
            TreeNode node = st2.pop();
            ans.add(node.val);
        }
        
        return ans;
    }
}