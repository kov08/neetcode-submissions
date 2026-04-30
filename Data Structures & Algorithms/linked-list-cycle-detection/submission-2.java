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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode s = head, f = head;

        while(s != null && f != null){
            if(s.next != null){ s = s.next; } else s = null; 
            if(f.next != null && f.next.next != null) f = f.next.next; else f = null;
            if(s != null && f != null && s == f) return true;
        }

        return false;
    }
}

// O(n): n is the length of the head list as we iterate through all the elements
// SC: O(1) to point-out two pointers s and f
