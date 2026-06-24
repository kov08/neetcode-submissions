class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();  
    }

    public void insert(String word) {
        Node node = root;          
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch); 
        }
        node.flag = true;
    }

    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)) return false;
            node = node.get(ch);
        }
        return node.flag;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.contains(ch)) return false;
            node = node.get(ch);
        }
        return true;
    }
}

class Node {
    Node[] arr;
    boolean flag;

    Node(){
        arr = new Node[26];
        flag = false;
    }
    
    boolean contains(char ch){ 
        if(arr[ch - 'a'] != null) 
            return true;
        return false;
    }

    void put(char ch, Node node){
        arr[ch - 'a'] = node;
    }

    Node get(char ch){
        return arr[ch - 'a'];
    }


}