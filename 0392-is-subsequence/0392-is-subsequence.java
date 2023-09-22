class Solution {
    public boolean isSubsequence(String s, String t) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(t.charAt(j)==s.charAt(i)){
                sb.append(t.charAt(j));
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        if(sb.toString().equals(s)){
            return true;
        }
        return false;
    }
}