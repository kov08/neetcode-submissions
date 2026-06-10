class LRUCache {
    Node left, right;
    int cap;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        this.left = new Node();
        this.right = new Node();
        this.left.next = right;
        this.right.prev = left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;        
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if( map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else if(map.size() < cap){
            Node node = new Node(key, value);
            map.put(key, node);
            insert(node);
        } else{
            Node node = new Node(key, value);
            Node lft = this.left.next;
            map.remove(lft.key);
            map.put(key, node);
            remove(lft);
            insert(node);
        }
    }

    private void remove(Node node){
        Node prv = node.prev;
        Node nxt = node.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    private void insert(Node node){
        Node prv = this.right.prev;
        prv.next = node;
        node.prev = prv;
        node.next = this.right;
        this.right.prev = node;
    }
}
class Node{
    Node next, prev;
    int key, val;

    public Node(int k, int v){
        this.key = k;
        this.val = v;
        next = null;
        prev = null;
    }
    
    public Node(){}
}
