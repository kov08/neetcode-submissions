class LRUCache {
    int cap;
    Map<Integer, Node> mp;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.mp = new HashMap<>();    
        this.left = new Node();
        this.right = new Node();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node n = mp.get(key);
        remove(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        Node node = new Node(key, value);
        mp.put(key, node);
        add(node);
        

        if(mp.size() > this.cap){
            Node n = this.left.next;
            mp.remove(n.key); 
            remove(n);
        }
    }

    private void add(Node node){
        Node prv = this.right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.right;
        this.right.prev = node;
    }
    
    private void remove(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }
}
class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(){};

    public Node(int k, int v){
        this.key = k;
        this.val = v;
        this.next = null;
        this.prev = null;
    }
}
