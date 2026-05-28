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
        // O(n+m) Time and O(1) Space
        // This is an optimized algo and you must memorize it.
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        while(current1 != null || current2 != null || carry != 0){
            int value1 = current1 == null ? 0 : current1.val;
            int value2 = current2 == null ? 0 : current2.val;
            int sum = value1 + value2 + carry;
            carry = sum >= 10 ? 1 : 0;
            int digit = sum % 10;
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = newNode;
            if(current1 != null) current1 = current1.next;
            if(current2 != null) current2 = current2.next;
        }
        return dummyHead.next;
    }
}
