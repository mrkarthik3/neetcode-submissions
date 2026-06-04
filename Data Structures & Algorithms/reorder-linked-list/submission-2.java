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
        ListNode slow = head;
        ListNode fast = head.next; // very important to start fast at head.next for this problem. MEMORIZE THIS....
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }                         

        // now slow is at mid point
        ListNode head2 = slow.next;

        // cutoff the link at midpoint
        slow.next = null;

        // reverse head2 linked list
        ListNode prev = null;
        ListNode current = head2;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        // prev is the head of reversed LL

        // Now merge the two lists alternately
        ListNode current1 = head.next;
        ListNode current2 = prev;
        ListNode tail = head;
        int count = 0;
        while(current1 != null && current2 != null){
            if(count % 2 == 0) {
                tail.next = current2;
                current2 = current2.next;
                tail = tail.next;
            } else {
                tail.next = current1;
                current1 = current1.next;
                tail = tail.next;
            }
            count++;
        }
        if(current1 == null) tail.next = current2;
        if(current2 == null) tail.next = current1;

        // Nothing to return. Just merge and let go..........
    }
}
