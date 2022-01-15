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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;
    else if (l1 == null) return l2;
    else if (l2 == null) return l1;
    int left = l1.val;
    int right = l2.val;
    if (left > right) return new ListNode(right, mergeTwoLists(l1, l2.next));
    else return new ListNode(left, mergeTwoLists(l1.next, l2));
  }
}
