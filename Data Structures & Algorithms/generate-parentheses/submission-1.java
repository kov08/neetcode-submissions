class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        rec(n,n, sb, lst);
        return lst;
    }

    private void rec(int ob, int cb, StringBuilder sb, List<String> lst){
        if(ob == 0 && cb == 0){
            lst.add(sb.toString());
            return;
        }

        if(ob > 0){
            sb.append('(');
            rec(ob -1, cb, sb, lst);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(cb > ob){
            sb.append(')');
            rec(ob, cb - 1, sb, lst);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// TC O(4^N)
// SC O(N)