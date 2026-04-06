class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0, strLen = str.length();

        while(i < strLen){
            int len = 0;

            while (str.charAt(i) != '#'){
                len = len * 10 + (str.charAt(i)-'0');
            i++;
            }
            // skip # 
            i++;
            
            res.add(str.substring(i, i + len));

            i += len;
        }

        return res;
    }
}
