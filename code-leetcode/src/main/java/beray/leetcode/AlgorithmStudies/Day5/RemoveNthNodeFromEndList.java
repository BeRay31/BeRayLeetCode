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
    ListNode firstPointer = head;
    ListNode secondPointer = head;
    int i = 0;
    while (firstPointer.next != null) {
        i++;
        firstPointer = firstPointer.next;
        if (i > n) secondPointer = secondPointer.next;
    }
    i++;
    if (secondPointer.next == null) return null;
    else if (i == n) return secondPointer.next;
    else secondPointer.next = secondPointer.next.next;
    return head;
  }
}
