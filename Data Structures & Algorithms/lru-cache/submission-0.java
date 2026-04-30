class LRUCache {
    int cap;
    Queue<Node> que;
    // We insert node in map for identification of the node in the queue
    Map<Integer, Node> mp;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.que = new LinkedList<>();
        this.mp = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left; 
    }

    // We need remove method to remove the node from the queue
    private void remove(Node node){
        Node lft = node.prev;
        Node rght = node.next;
        lft.next = rght;
        rght.prev = lft;
    }

    // We also need insert method to insert the node at the end od the queue
    private void insert(Node node){
        // To insert the new node at the right most side of the que
        Node prv = this.right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        // Fist check that do we have this key in our mp to get the val 
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            // Now we change it's position in the queue so that it will become the most recently used node
            remove(node);
            insert(node);
            // Now return the val
            return node.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // first we check in the mp that do we carry this key to remove the existing node from the queue
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        //  Now we create a new node and insert in the queue at last posiiton(recently used)
        Node nNode = new Node(key, value);
        insert(nNode);
        mp.put(key, nNode);

        // Now we do need to check the length of the LRU to remove the LRU node
        if(mp.size() > this.cap){
            Node node = this.left.next;
            mp.remove(node.k);
            remove(node);
        }

    }
}

class Node { 
    int k, v;
    Node prev, next;

    public Node(int k, int v){
        this.k = k;
        this.v = v;
        this.prev = null;
        this.next = null;
    }
}

// TC: O(1) by using left and right pointers to insert and remove nodes and keep track of Node for the given key using map.
// SC: O(n) where n is the capacity of the LRU cache
