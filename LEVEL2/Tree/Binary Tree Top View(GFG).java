//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{   
    static class Pair{
        Node node;
        int vlevel;
        
        Pair(int vlevel, Node node){
            this.vlevel = vlevel;
            this.node = node;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,root));
        
        HashMap<Integer, Node> map = new HashMap<>();
        
        int minLevel = 0;
        
        while(q.size() > 0){
            Pair p = q.remove();
            int currLevel = p.vlevel;
            Node node = p.node;
            
            if(map.get(currLevel)== null){
                map.put(currLevel, node);
            }
            
            if(node.left != null){
                // if(minLevel > currLevel-1){
                //     minLevel = currLevel-1;
                // }
                
                minLevel = minLevel > currLevel-1 ? currLevel-1 : minLevel;
                q.add(new Pair(currLevel-1, node.left));
            } 
            
            if(node.right != null){
                q.add(new Pair(currLevel+1, node.right));
            }
        }
        
        
        while(map.containsKey(minLevel)){
            ans.add(map.get(minLevel).data);
            minLevel++;
        }
        
        
        return ans;
    }
}