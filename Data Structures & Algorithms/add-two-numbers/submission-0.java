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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode revL1 = reverse(l1);
        // ListNode revL2 = reverse(l2);
        ListNode ans = new ListNode();
        ListNode ret = ans;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int v1  = l1 != null ?  l1.val : 0;
            int v2  = l2 != null ?  l2.val : 0;
            
            int sum = v1 + v2 + carry; 
            carry = sum / 10;
            ret.next = new ListNode(sum % 10);
            
            ret = ret.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }        
        return ans.next;
        // return reverse(ans.next);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, d = head;
        while(d != null ){
            ListNode temp = d.next;
            d.next = prev;
            prev = d;
            d = temp;
        }
        return prev;
    }
}
