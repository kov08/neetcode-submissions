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

class Solution {
    public void reorderList(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        // Rotate second half;
        ListNode cur = s.next, prev = null;
        while(cur != null){
            ListNode t = cur.next;
            cur.next  = prev;
            prev = cur;
            cur = t;
        }
        // Merge rotated half with the s pointer
        s.next = prev;

        // Modifying the LL
        ListNode dummy = head;
        while(s.next != null){
            ListNode t = dummy.next;
            ListNode c = s.next;
            dummy.next = c;
            s.next = c.next;
            c.next = t;
            dummy = t;
        }

    }
}
