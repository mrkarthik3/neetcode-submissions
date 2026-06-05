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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next; // new head of LL to be reversed
        slow.next = null; // cut off link

        ListNode prev = null;
        ListNode current = head2;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        // prev is the head of reversed LL

        ListNode current1 = head; // first half of original LL
        ListNode current2 = prev; // reversed other half

        int maxSum = Integer.MIN_VALUE;
        while(current1 != null && current2 != null) {
            maxSum = Math.max(maxSum, current1.val + current2.val);
            current1 = current1.next;
            current2 = current2.next;
        }

        return maxSum;


        
    }
}