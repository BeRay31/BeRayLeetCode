package beray.leetcode.AlgorithmStudies.Day8;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulateNextRightPointer {
  public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
  };

  // The input is perfect binary tree so i assume there is no null pointer except right on the right side of the tree

  public void connectHelper(Node left, Node right) {
    if (left == null) return; 
    left.next = right;
    connectHelper(left.left, left.right);
    if (right == null) return;
    connectHelper(left.right, right.left);
    connectHelper(right.left, right.right);
    connectHelper(right.right, null);
  }

  public Node connect(Node root) {
    connectHelper(root, null);
    return root;
  }
}
