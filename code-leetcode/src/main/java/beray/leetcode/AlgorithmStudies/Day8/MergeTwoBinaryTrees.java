package beray.leetcode.AlgorithmStudies.Day8;

public class MergeTwoBinaryTrees {
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

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return null;
    int sum = 0;
    TreeNode left = root1;
    TreeNode right = root2;
    TreeNode ll = null, lr = null, rl = null, rr = null;
    if (left != null) {
      sum += left.val;
      ll = left.left;
      lr = left.right;
    }
    if (right != null) {
      sum += right.val;
      rl = right.left;
      rr = right.right;
    }
    return new TreeNode(sum, mergeTrees(ll, rl), mergeTrees(lr, rr));
  }
}
