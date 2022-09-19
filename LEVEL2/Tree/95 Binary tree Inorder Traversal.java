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
        //my work
        ans.add(root.val);
        //right
        helper(root.right, ans);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        // helper(root, ans);
        
        //Itreative solution
        Stack<TreeNode> st = new Stack<>();
        
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                if(st.size() == 0){
                    break;
                }
                
                root = st.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}