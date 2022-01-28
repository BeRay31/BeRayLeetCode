package beray.leetcode.AlgorithmStudiesII.Day7;
// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean cmpSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) return true;
    else if ((root == null && subRoot != null) || (root != null && subRoot == null)) return false;
    return root.val == subRoot.val && cmpSubtree(root.left, subRoot.left) && cmpSubtree(root.right, subRoot.right);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    return cmpSubtree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
 
}
