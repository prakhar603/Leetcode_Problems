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
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>() ; 
        ArrayList<Integer> list = new ArrayList<>() ; 
        
        if(root == null) {
            return list ; 
        }
        
        q.add(root) ; 
        
        while(!q.isEmpty()) {
            
            int n = q.size() ; 
            
            for(int i = 0; i < n; i++) {
                
                TreeNode temp = q.remove() ; 
                
                if(temp.left != null) {
                    q.add(temp.left) ; 
                }
                if(temp.right != null) {
                    q.add(temp.right) ; 
                }
                
                if(i == n - 1) {
                    list.add(temp.val) ; 
                }
            }
        }
        return list ; 
    }
}