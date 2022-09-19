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
    //Recursive code
    public void helper(TreeNode root, List<Integer>ans){
        if(root == null) return;
        
        ans.add(root.val);
        
        helper(root.left, ans);
        
        helper(root.right, ans);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        // helper(root, ans);
        
        
        //Iterative code
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(st.size()>0){
            TreeNode node = st.pop();
            ans.add(node.val);
            
            //check for right first -> bcoz of LIFO symactic in stack
            if(node.right != null){
                st.push(node.right);
            }
            
            //check for left node
            if(node.left != null){
                st.push(node.left);
            }
            
        }
        
        return ans;
    }
}