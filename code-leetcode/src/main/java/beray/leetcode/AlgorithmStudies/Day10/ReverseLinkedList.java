package beray.leetcode.AlgorithmStudies.Day10;
// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode recursionHelper(ListNode p1, ListNode p2) {
    ListNode temp = p2.next;
    p2.next = p1;
    if (p2.next == null) return p2;
    else return recursionHelper(p2, temp);
  }

  public ListNode reverseListRecursion(ListNode head) {
    if (head == null || head.next == null) return head;
    return recursionHelper(new ListNode(head.val), head.next);
  }

  public ListNode reverseListIterative(ListNode head) {
    if (head == null) return head;
    ListNode newHead = null;
    ListNode fp = newHead;
    ListNode sp = head;

    while (sp.next != null) {
      ListNode temp = sp.next;
      sp.next = fp;
      fp = sp;
      sp = temp;
    }
    sp.next = fp;

    return sp;
  }
}
