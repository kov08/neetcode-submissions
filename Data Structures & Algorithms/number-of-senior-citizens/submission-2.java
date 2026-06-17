class Solution {
    public int countSeniors(String[] details) {
        
        int ans = 0;
        for(String str : details){
            char one = str.charAt(11);
            char two = str.charAt(12);{
                if(one > '6' || (one =='6' && two > '0')){
                    ans++;
                }
            }
        }
        return ans;
    }
}