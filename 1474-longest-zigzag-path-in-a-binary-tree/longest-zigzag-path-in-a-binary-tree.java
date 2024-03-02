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
    private int max = 0;
    public int longestZigZag(TreeNode root) {
        helper(root.left, 0, 1);
        helper(root.right, 1, 1);
        return max;
    }
    private void helper(TreeNode n, int flag, int l){
        if(n == null)
            return;
        if(l > max)
            max = l;
        if(flag == 0){
            helper(n.left, 0, 1);
            helper(n.right, 1, l+1);
        }
        else{
            helper(n.left, 0, l+1);
            helper(n.right, 1, 1);
        }
    }
}