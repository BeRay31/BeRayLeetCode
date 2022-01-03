package beray.leetcode.AlgorithmStudies.Day5;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fp = head;
    ListNode sp = fp;
    int count = 0;
    while (fp.next != null) {
      fp = fp.next;
      count++;
      if (count > n) sp = sp.next;
    }
    count++;

    if (count == n) return head.next;
    else sp.next = sp.next.next;
    return head;
  }
}