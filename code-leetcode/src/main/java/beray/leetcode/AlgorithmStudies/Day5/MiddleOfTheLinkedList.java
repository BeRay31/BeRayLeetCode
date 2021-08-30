package beray.leetcode.AlgorithmStudies.Day5;
// https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOfTheLinkedList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode middleNode (ListNode head) {
    int counter = 0;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      counter++;
    }

    int middle = counter/2;
    int idx = 0;
    node = head;
    while (idx != middle) {
      node = node.next;
      idx++;
    }
    return node;
  }
}
