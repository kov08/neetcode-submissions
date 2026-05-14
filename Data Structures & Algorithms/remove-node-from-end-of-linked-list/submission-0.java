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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode f = new ListNode();
        f.next = head;
        while(c < n && f.next != null){
            c++;
            f = f.next;
        }

        ListNode s = new ListNode();
        s.next  = head;
        ListNode ans = s;
        
        while(f != null && f.next != null){
            s = s.next;
            f = f.next;
        }
        
        ListNode ref = s.next.next;
        s.next = ref;

        return ans.next;
    }
}
