class Solution {
    Set<String> dic;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dic=new HashSet<>();
        dp=new int[s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(String word : dictionary) dic.add(word);
        return solve(0,s);
    }

    public int solve(int idx, String s){
        if(idx>=s.length()) return 0;
        if(dic.contains(s.substring(idx,s.length()))) return 0;
        if(dp[idx]!=Integer.MAX_VALUE) return dp[idx];
        int min=s.length()-idx;
        for(int i=idx+1; i<=s.length(); i++){
            int c=dic.contains(s.substring(idx,i))?0:i-idx;
            c+=solve(i,s);
            min=Math.min(min,c);
        }
        return dp[idx]=min;
        // return min;
    }
}