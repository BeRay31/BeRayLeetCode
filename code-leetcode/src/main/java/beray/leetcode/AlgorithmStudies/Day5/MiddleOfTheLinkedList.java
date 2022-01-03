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
    int count = 0;
    ListNode fp = head;
    while (fp != null) {
      count++;
      fp = fp.next;
    }
    if (count <= 1) return head;
    int mid = count/2;
    for (int i = 0; i < mid; i++) head = head.next;
    return head;
  }
}
