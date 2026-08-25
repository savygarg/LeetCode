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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        ArrayList<Integer> values = new ArrayList<>();
        for(TreeNode x : nodes)
            values.add(x.val);
        Collections.sort(values);
        for(int i = 0; i < nodes.size(); i++)
            nodes.get(i).val = values.get(i);
    }
    void inorder(TreeNode root, ArrayList<TreeNode> nodes) {
        if(root == null)
            return;
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }
}