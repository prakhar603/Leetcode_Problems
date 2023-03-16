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
        for(int i=0; i < inorder.length ; i++) {
            map.put(inorder[i], i) ; 
        }
        
        return constructTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map) ; 
    }
    public TreeNode constructTree(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend,
                                 HashMap<Integer, Integer> map) {
        
        if(poststart > postend || instart > inend) 
            return null ; 
        
        TreeNode root = new TreeNode(postorder[postend]) ; 
        int rootIdx = map.get(postorder[postend]) ; 
        int elementsRight = inend - rootIdx ; 
        
        root.left = constructTree(postorder, poststart, postend-1-elementsRight  ,inorder, instart, rootIdx - 1, map) ; 
        root.right = constructTree(postorder, postend - elementsRight, postend - 1, inorder, rootIdx + 1, inend, map) ; 
        
        return root ; 
        
    }
}