package beray.leetcode.AlgorithmStudiesII.Day3;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
public class RemoveDuplicates {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head; 
    ListNode fp = head;
    ListNode sp = head.next;
    ListNode ans = new ListNode(0, head);

    while (sp != null) {
      if (ans.next == fp && fp.val == sp.val) { // trim first
        while(fp.val == sp.val) sp = sp.next;
        fp = sp;
        ans.next = fp;
        if (sp != null) sp = sp.next;
      } else if (sp.next != null && sp.val == sp.next.val) {
        ListNode tp = sp.next;
        while (tp != null && sp.val == tp.val) tp = tp.next;
        fp.next = tp;
        sp = tp;
      } else {
        fp = sp;
        sp = sp.next;
      }
    }
    return ans.next;
  }
  public ListNode deleteDuplicatesAdvance(ListNode head) {
    if (head == null || head.next == null) return head; 
    ListNode ans = new ListNode(0, head);
    ListNode fp = ans;
    ListNode sp = ans.next;
    ListNode tp = ans.next.next;

    while (tp != null) {
      if (sp.val == tp.val) {
        while (tp != null && sp.val == tp.val) tp = tp.next;
        fp.next = tp;
        sp = tp;
        if (tp != null) tp = tp.next;
      } else {
        fp = fp.next;
        if (fp != null) sp = fp.next;
        else sp = null;
        if (sp != null) tp = sp.next;
        else sp = null;
      }
    }
    return ans.next;
  }
}
