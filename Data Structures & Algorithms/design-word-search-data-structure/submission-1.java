class WordDictionary {

    // TC O(N) add: word length + O(N) if ch!= '.' O(26^n) if all char in find id '.'
    // SC O(sum of(26*) ( M * N) ) where N: average length of words and M: number of  words in worst case where all words are unique 
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                node.put(ch, new Node());
            }
            node  = node.getChild(ch);
        }
        node.isEndOfTheWord();
    }

    public boolean search(String word) {
        Node node = root;
        return rec(word,0,node);
    }

    private boolean rec(String word, int i, Node n){
        if(n == null) return false;
        if(i == word.length()) return n.isEnd();

        char ch = word.charAt(i);
        
        if(ch != '.'){
            return (rec(word, i+1, n.getChild(ch))); 
        } else{
            for(int ind = 0; ind < 26; ind++){
                Node child = n.get(ind);
                if(child != null && rec(word, i+1, child))
                    return true;
            }
        }
        return false;
    }
}

class Node{
    Node[] arr;
    boolean flag;

    Node(){
        arr = new Node[26];
        flag = false;
    }

    boolean contains(char ch){
        return arr[ch - 'a'] != null;
    }
    void put(char ch, Node node){
        arr[ch  - 'a'] = node;
    }
    Node getChild(char ch){
        return arr[ch - 'a'];
    }
    void isEndOfTheWord(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
    Node get(int index){
        return arr[index];
    }
}
