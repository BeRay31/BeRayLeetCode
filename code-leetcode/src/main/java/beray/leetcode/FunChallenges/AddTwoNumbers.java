package beray.leetcode.FunChallenges;
public class AddTwoNumbers {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int val) { this.val = val; }
  }

  public ListNode solutionIterative(ListNode l1, ListNode l2) {
    ListNode solutionHead = new ListNode(0);
    ListNode currElmt = solutionHead;
    int carry = 0;
    while(l1 != null || l2 != null) {
      int val1 = l1 != null ? l1.val : 0;
      int val2 = l2 != null ? l2.val : 0;
      int sum = val1 + val2 + carry;
      carry = sum/10;
      currElmt.next = new ListNode(sum%10);
      currElmt = currElmt.next;
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
    }
    if(carry > 0) {
      currElmt.next = new ListNode(carry);
    }
    return solutionHead.next;
  }

  public static ListNode solutionRecursive(ListNode l1, ListNode l2) {
    ListNode solHead = new ListNode(0);
    recc(l1, l2, solHead, 0);
    return solHead.next;
  }

  public static void recc(ListNode l1, ListNode l2, ListNode sol, int carry) {
    if(l1 == null && l2 == null) {
      if(carry > 0) {
        sol.next = new ListNode(carry);
      }
      return;
    }
    int val1 = l1 != null ? l1.val : 0;
    int val2 = l2 != null ? l2.val : 0;
    int sum = val1 + val2 + carry;
    sol.next = new ListNode(sum%10);
    ListNode nextElmt1 = l1 != null ? l1.next : l1;
    ListNode nextElmt2 = l2 != null ? l2.next : l2;
    recc(nextElmt1, nextElmt2, sol.next, sum/10);
  }

  public static void print(ListNode l) {
    while(l != null) {
      System.out.print(l.val);
      l = l.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode test1 = new ListNode(1,
      new ListNode(6,
      new ListNode(0,
      new ListNode(3,
      new ListNode(3,
      new ListNode(6,
      new ListNode(7,
      new ListNode(2,
      new ListNode(0,
      new ListNode(1
      ))))))))));
    ListNode test2 = new ListNode(6,
    new ListNode(3,
    new ListNode(0,
    new ListNode(8,
    new ListNode(9,
    new ListNode(6,
    new ListNode(6,
    new ListNode(9,
    new ListNode(6,
    new ListNode(1
    ))))))))));
    
    print(solutionRecursive(test1, test2));
  }
}
