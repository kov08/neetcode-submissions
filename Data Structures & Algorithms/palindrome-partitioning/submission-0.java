class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> lst  =new ArrayList<>();
        rec(0, s, lst, ans);
        return ans;
    }

    private void rec(int ind, String s, List<String> lst, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(lst));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(palindrom(s, ind, i)){
                lst.add(s.substring(ind, i+1));
                rec(i+1, s, lst, ans);
                lst.remove(lst.size() -1);
            }
        }
    }

    private boolean palindrom(String s, int start, int end ){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
