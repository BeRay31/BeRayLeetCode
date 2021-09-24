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
    if (head == null || head.next == null) return head;
    ListNode p1 = head;
    ListNode p2 = head.next;
    p1.next = null;
    while(p2.next != null) {
      ListNode temp = p2.next;
      p2.next = p1;
      p1 = p2;
      p2 = temp;
    }
    p2.next = p1;
    return p2;
  }
}
