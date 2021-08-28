public class MergeTwoSortedList {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static ListNode solution(ListNode l1, ListNode l2) {
    ListNode tempAns = new ListNode(0);
      ListNode currElm = tempAns;
      while(l1 != null || l2 != null) {
        if (l1 == null) {
          currElm.next = new ListNode(l2.val);
          currElm = currElm.next;
          l2 = l2.next;
        } else if (l2 == null) {
          currElm.next = new ListNode(l1.val);
          currElm = currElm.next;
          l1 = l1.next;
        }
        else if(l1 == null || l1.val > l2.val) {
          currElm.next = new ListNode(l2.val);
          currElm = currElm.next;
          l2 = l2.next;
        } else {
          currElm.next = new ListNode(l1.val);
          currElm = currElm.next;
          l1 = l1.next;
        }
      }
      ListNode ans = tempAns.next;
      return ans;
  }
}
