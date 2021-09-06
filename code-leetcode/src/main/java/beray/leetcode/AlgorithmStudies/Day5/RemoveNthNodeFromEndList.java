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
    ListNode lastPointer = head;
    int counter = 0;
    while (lastPointer.next != null) {
      lastPointer = lastPointer.next;
      counter++;
      if (counter > n) {
        firstPointer = firstPointer.next;
      }
    }
    counter++;
    if (firstPointer.next == null) return firstPointer.next;
    else if(n == counter) return lastPointer;
    else firstPointer.next = firstPointer.next.next;

    return head;
  }
}
