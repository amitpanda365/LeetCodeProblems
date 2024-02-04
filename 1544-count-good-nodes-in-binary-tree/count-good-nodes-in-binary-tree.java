
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        countGoodNodes(root, root.val);
        return count;
    }

    public void countGoodNodes(TreeNode n, int max){
        if(n == null)
            return;
        if(n.val >= max){
            count++;
            max = n.val;
        }
        countGoodNodes(n.left, max);
        countGoodNodes(n.right, max);
    }
}