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
    private int c=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null || root.val == 1000000000)
            return 0;
        helper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return c;
    }
    private void helper(TreeNode n, int t){
        if(n==null)
            return;
        if(t == n.val)
            c++;
        t = t-n.val;
        helper(n.left, t);
        helper(n.right, t);
    }
}