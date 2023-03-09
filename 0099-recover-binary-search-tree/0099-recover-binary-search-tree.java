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
        
        TreeNode firstNode = null ; 
        TreeNode secondNode = null ; 
        TreeNode temp = new TreeNode(Integer.MIN_VALUE) ; 
        
    public void recoverTree(TreeNode root) {
        
        if(root == null) return ; 
       
        inorderTraversal(root) ; 
        
        int temp2 = firstNode.val ; 
        firstNode.val = secondNode.val ;
        secondNode.val = temp2 ; 
        
    }
    
    public void inorderTraversal(TreeNode root) {
        
        if(root == null) {
            return  ; 
        } 
        
        inorderTraversal(root.left) ; 
        
        if(temp.val > root.val && firstNode == null) {
            firstNode = temp ; 
            secondNode = root ; 
        //   System.out.println("updating first" + first.val) ; 
        }
        else if(temp.val > root.val && firstNode != null) {
            secondNode = root ; 
        }
        
        temp = root ;
        
        inorderTraversal(root.right) ; 
    }
}