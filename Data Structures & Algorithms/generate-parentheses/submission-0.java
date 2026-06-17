class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rec(0, 0, sb, n, ans);
        return ans;
    }

    private void rec(int opening, int closing, StringBuilder sb, int maxPairs, List<String> ans){
        if(sb.length() == maxPairs * 2){
            ans.add(sb.toString());
            return;
        }
        
        if(opening < maxPairs){
            sb.append('(');
            rec(opening+1, closing, sb, maxPairs, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closing < opening){
            sb.append(')');
            rec(opening, closing+1, sb, maxPairs, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

// TC O(2^2n) because pair contains 2 brackets 
// SC O(n) stack space
