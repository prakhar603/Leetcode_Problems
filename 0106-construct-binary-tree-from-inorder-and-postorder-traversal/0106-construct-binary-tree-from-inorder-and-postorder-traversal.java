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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>() ; 
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i) ; 
        }
        
        return constructTree(postorder, 0, postorder.length -1, inorder, 0, inorder.length -1, map) ; 
    }
    
    public TreeNode constructTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, 
                                  HashMap<Integer, Integer> map) {
        
        if(inStart > inEnd || postStart > postEnd) 
            return null ; 
        
        TreeNode root = new TreeNode(postorder[postEnd]) ; 
        
        int rootIdx = map.get(postorder[postEnd]) ; 
        int numsRight = inEnd - rootIdx ; 
        
        root.left = constructTree(postorder, postStart, postEnd - numsRight - 1, inorder, inStart, rootIdx - 1, map) ; 
        root.right = constructTree(postorder, postEnd - numsRight, postEnd - 1, inorder, rootIdx + 1, inEnd, map) ; 
        
        return root ; 
    }
}