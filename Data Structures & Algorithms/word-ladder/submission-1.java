class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        
        Set<String> st = new HashSet<>();
        st.addAll(wordList);
        // System.out.println("Print out: "+st.toString()+ " ||  " + st.size()+ " & "+ wordList.size());
        Deque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(beginWord, 1));
        st.remove(beginWord);
        
        while(!que.isEmpty()){

            Pair pr = que.pop();
            if(pr.word.equals(endWord)) return pr.sec;
                String str = pr.word;
                int count = pr.sec;
            
            for(int i = 0; i < beginWord.length(); i++){
                char[] carr = str.toCharArray();       
                
                for(char ch = 'a'; ch <= 'z'; ch++){
                    carr[i] = ch;
                    String wrd = new String(carr);
                    if(st.contains(wrd)){
                        
                        que.add(new Pair(wrd, count+1));
                        st.remove(wrd);
                    }
                }
            }
        }
        return 0;
    }

}

class Pair {
    String word;
    int sec;
    public Pair (String word, int second){
        this.word = word;
        this.sec = second;
    }
}
