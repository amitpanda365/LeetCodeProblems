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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        fn(root, 0);
        return list;
    }

    private void fn(TreeNode n, int l){
        if(n == null)
            return;
        if(l == list.size())
            list.add(n.val);
        fn(n.right, l+1);
        fn(n.left, l+1);
    }
}