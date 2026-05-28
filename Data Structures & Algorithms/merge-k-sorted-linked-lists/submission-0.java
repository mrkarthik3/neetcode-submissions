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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        for(ListNode list : lists) {
            // only add non empty linkedlists' head pointers into min heap
            if(list != null) {
                minHeap.offer(list);
            }
        }
        
        // At any point, max ListNodes inside minHeap = k (# of lists)
        while(!minHeap.isEmpty()) {
            ListNode newNode = minHeap.poll();
            tail.next = newNode;
            tail = newNode;
            
            // adding pointer to next node in a linkedlist.
            if(newNode.next != null) {
                minHeap.offer(newNode.next);
            }
        }

        return dummyHead.next;

    }
}
