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
        Node copy = head;
        Map<Node, Node> mp = new HashMap<>();

        while(copy != null){
            mp.put(copy, new Node(copy.val));
            copy = copy.next;
        }

        copy = head;
        while(copy != null){
            Node node = mp.get(copy);
            node.next = mp.get(copy.next);
            node.random = mp.get(copy.random);
            copy = copy.next; 
        }

        return mp.get(head);
    }
}
