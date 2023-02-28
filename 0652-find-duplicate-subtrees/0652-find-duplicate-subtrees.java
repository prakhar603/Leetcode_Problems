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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        HashMap<String, Integer> map = new HashMap<>() ; 
        List<TreeNode> list = new ArrayList<>() ; 
        
        helper(root, map, list) ; 
        
        return list ; 
        
    }
    public String helper(TreeNode node, HashMap<String, Integer> map, List<TreeNode> list) {
        
        if(node == null) 
            return "" ; 
        
        String left = helper(node.left, map, list) ; 
        String right = helper(node.right, map, list) ; 
        int nodeValue = node.val ; 
        
        String subtree = nodeValue + "." + left + "." + right ; 
        
//         System.out.println(map) ; 
//         System.out.println("subtree " + subtree) ; 
        
        int count = map.getOrDefault(subtree, 0) ;
       // System.out.println(count) ; 
        if(count == 1) {
            list.add(node) ; 
          //  System.out.println(node) ;
        }
        map.put(subtree, map.getOrDefault(subtree, 0)+1) ; 
        
        return subtree ; 
    }
}