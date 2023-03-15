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
    public boolean isCompleteTree(TreeNode root) {
        
         Deque<TreeNode> bfs = new ArrayDeque<>();
        bfs.offerLast(root);
        boolean found = false;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = bfs.removeFirst();
                if (cur.left != null) {
                    if (found) return false;
                    bfs.offerLast(cur.left);
                } else {
                    found = true;
                }
                if (cur.right != null) {
                    if (found) return false;
                    bfs.offerLast(cur.right);
                } else {
                    found = true;
                }
            }
        }
        return true; 
        
    }
}