package beray.leetcode.AlgorithmStudies.Day10;
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public void recursionHelper(ListNode l1, ListNode l2) {
    if (l2 == null) return;
    if (l1.next != null) {
      if (l1.next.val < l2.val) {
        recursionHelper(l1.next, l2);
      } else {
          ListNode temp = l1.next;
          ListNode temp2 = l2.next;
          l1.next = l2;
          l1.next.next = temp;
          recursionHelper(l1.next, temp2);
      }
    } else {
      l1.next = l2;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode head = l1.val > l2.val ? l2 : l1;
    ListNode target = l1.val > l2.val ? l1 : l2;
    recursionHelper(head, target);
    return head;
  }
}
