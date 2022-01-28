package beray.leetcode.AlgorithmStudiesII.Day7;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
import java.util.*;
public class PopulateRightNextPointerII {
  class Node {
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
  }

  class Pair<F, S> {
    public F first;
    public S second;

    public Pair(F first, S second) {
      this.first = first;
      this.second = second;
    }
  }

  public Node connect(Node root) {
    if (root == null) return root;
    Queue<Pair<Node, Integer>> q = new LinkedList<Pair<Node, Integer>>();
    q.add(new Pair<Node, Integer>(root, 0));
    while (!q.isEmpty()) {
      Pair<Node, Integer> curr = q.poll();
      Pair<Node, Integer> next = q.peek();
      if (next == null || curr.second < next.second) curr.first.next = null;
      else curr.first.next = next.first;

      if (curr.first.left != null) q.add(new Pair<Node, Integer>(curr.first.left, curr.second + 1));
      if (curr.first.right != null) q.add(new Pair<Node, Integer>(curr.first.right, curr.second + 1)); 
    }
    return root;
  }
}
