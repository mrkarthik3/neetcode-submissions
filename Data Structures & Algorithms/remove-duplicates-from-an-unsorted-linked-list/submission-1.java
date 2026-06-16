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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        ListNode current = head;
        while(current != null){
            counter.put(current.val, counter.getOrDefault(current.val, 0)+1);
            current = current.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        current = head;
        System.out.println(counter);
        while(current != null) {
            if(counter.get(current.val) == 1){
                // remove this duplicate node
                tail.next = current;
                tail = current;
            }
            current = current.next;
        }
        tail.next = null;

        return dummyHead.next;
        
    }
}
