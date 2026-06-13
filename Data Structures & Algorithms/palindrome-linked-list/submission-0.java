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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow;
        // reverse from slow
        ListNode current = head2;
        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // head of reversed LL = prev
        head2 = prev; // reassign

        ListNode current1 = head;
        ListNode current2 = head2;

        while(current1 != null && current2 != null){
            if(current1.val != current2.val) return false;
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
        
    }
}