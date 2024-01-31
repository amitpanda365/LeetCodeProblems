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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        saveLeafNodes(root1, al1);
        saveLeafNodes(root2, al2);

        return al1.equals(al2);
    }

    public void saveLeafNodes(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right ==null)
            list.add(root.val);
        saveLeafNodes(root.left, list);
        saveLeafNodes(root.right, list);
    }
}
