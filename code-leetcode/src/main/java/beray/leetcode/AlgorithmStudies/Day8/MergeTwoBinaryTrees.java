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

  public void mergeHelper(TreeNode res, TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) return;
    int tree1Val = tree1 == null ? 0 : tree1.val;
    int tree2Val = tree2 == null ? 0 : tree2.val;
    int sum = tree1Val + tree2Val;
    res.val = sum;
    
    TreeNode left1 = tree1 == null ? null : tree1.left;
    TreeNode left2 = tree2 == null ? null : tree2.left;
    
    TreeNode right1 = tree1 == null ? null : tree1.right;
    TreeNode right2 = tree2 == null ? null : tree2.right;
    
    if (left1 != null || left2 != null) {
      TreeNode newLeft = new TreeNode();
      res.left = newLeft;
      mergeHelper(res.left,left1, left2);
    }
    
    if (right1 != null || right2 != null) {
      TreeNode newRight = new TreeNode();
      res.right = newRight;
      mergeHelper(res.right, right1, right2);
    }
  }

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return null;
    TreeNode resTree = new TreeNode();
    mergeHelper(resTree, root1, root2);
    return resTree;
  }
}
