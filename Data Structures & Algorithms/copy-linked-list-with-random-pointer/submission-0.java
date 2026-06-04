/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> repo = new HashMap<>();
        Node current = head;

        repo.put(null, null); // required 

        // create a cloned node for each original node with no connections
        while(current != null){
            Node clonedNode = new Node(current.val);
            repo.put(current,clonedNode);
            current = current.next;
        }

        // Do another pass on original and make connections in clone
        current = head;
        while(current != null){
            Node clone = repo.get(current);
            clone.next = repo.get(current.next);
            clone.random = repo.get(current.random);
            current = current.next;
        }

        return repo.get(head);
    }
}
