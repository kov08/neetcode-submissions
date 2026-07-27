class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
// TC: O(len of String: N) + O(len of sb)

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int ind = 0, strLen = str.length();

        while(ind < strLen){
            int len = 0;
            
            while(str.charAt(ind) != '#'){
                len = len *10 + (str.charAt(ind) - '0');
                ind++;
            }
            ind++;
            ans.add(str.substring(ind, ind + len));
            ind = ind + len;
        } 

        return ans;        
    }
}

// TC: O(len of str)