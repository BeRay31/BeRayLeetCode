package FunChallenges;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbersII {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  
  public static ListNode solution(ListNode l1, ListNode l2) {
    int length1 = length(l1);
    int length2 = length(l2);
    if(length1 > length2) {
      int diff = length1 - length2;
      for(int i = 0; i < diff; i++) {
        ListNode newHead = new ListNode(0);
        newHead.next = l2;
        l2 = newHead;
      }
    } else if(length1 < length2) {
      int diff = length2 - length1;
      for(int i = 0; i < diff; i++) {
        ListNode newHead = new ListNode(0);
        newHead.next = l1;
        l1 = newHead;
      }
    }
    ListNode solutionHead = new ListNode(0);
    int carry = solution(l1, l2, solutionHead);
    if(carry > 0) {
      solutionHead.val = carry;
      return solutionHead;
    } else {
      return solutionHead.next;
    }
  }

  public static int solution(ListNode l1, ListNode l2, ListNode Sol) {
    print(Sol);
    if(l2 == null) {
      return 0;
    } else {
      int sum = l1.val + l2.val;
      Sol.next = new ListNode(sum%10);
      int carry = solution(l1.next, l2.next, Sol.next);
      sum += carry;
      Sol.next.val = sum%10;
      return sum/10;
    }
  }

  public static int length(ListNode l) {
    if(l == null) return 0;
    int count = 1;
    ListNode currElmt = l;
    while(currElmt.next != null) {
      count++;
      currElmt = currElmt.next;
    }
    return count;
  }

  public static void print(ListNode l) {
    while(l != null) {
      System.out.print(l.val);
      l = l.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(7, 
      new ListNode(2, 
      new ListNode(4, 
      new ListNode(3
      ))));
    ListNode test2 = new ListNode(5, 
      new ListNode(6, 
      new ListNode(4
    )));
    print(test);
    print(test2);
    print(solution(test, test2));
  }
}
