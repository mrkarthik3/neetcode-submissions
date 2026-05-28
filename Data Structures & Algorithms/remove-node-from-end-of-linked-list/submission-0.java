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
        // O(n) Time & O(1) Space
        // removing nth node from end = removing (len-n)th index (0 indexed) node from start
        int len = 0;
        ListNode current = head;
        while(current != null) {
            len++;
            current = current.next;
        }

        int idxFromStart = len - n;

        // if 0th index is to be removed, then just return head.next;
        if(idxFromStart == 0) return head.next;
        
        current = head; // reset
        ListNode prev = null;
        int count = 0;
        while(current != null) {
            if(count == idxFromStart) {
                prev.next = current.next;
                break;
            }
            count++;
            prev = current;
            current = current.next;
        }

        return head; 
    }
}
