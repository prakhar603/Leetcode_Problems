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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer, Integer> map = new HashMap<>() ; 
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i) ; 
        }
        
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map) ; 
        
    }
    public TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                                  HashMap<Integer, Integer> map) {
        
        if(preStart > preEnd || inStart > inEnd)
            return null ;
        
        TreeNode root = new TreeNode(preorder[preStart]) ; 
        
        int rootIdx = map.get(root.val) ; 
        int numsLeft = rootIdx - inStart ; 
        
        root.left = constructTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, rootIdx - 1, map) ; 
        root.right = constructTree(preorder, preStart + numsLeft + 1, preEnd, inorder, rootIdx + 1, inEnd, map) ; 
        
        return root ; 
    }
}