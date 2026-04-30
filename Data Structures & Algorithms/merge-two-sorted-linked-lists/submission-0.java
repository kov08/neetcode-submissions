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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d1 = new ListNode();
        ListNode ans = d1;
        
        while(list1 != null && list2 != null){
            int n1 = list1.val, n2 = list2.val;

            if(n1 >= n2){
                ListNode tmp = list2.next;
                list2.next = null;
                d1.next = list2;
                list2 = tmp;
            } else { 
                ListNode tmp = list1.next;
                list1.next = null;
                d1.next = list1;
                list1 = tmp;
            }
            d1 = d1.next;
        } 

        if(list1 != null){
            d1.next = list1;
        }

        if(list2 != null){
            d1.next = list2;
        }

        return ans.next;
    }
}

// TC: O(m + n) where mand n is the length of the list1 and list2
// sc: O(m + n) length of the new list 