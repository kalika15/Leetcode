class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length()-1; i++){
            sb.append(s.charAt(i));
            StringBuilder temp=new StringBuilder();
            while(temp.length()<s.length()){
                temp.append(sb);
            }
            String curr=temp.toString();
            if(curr.equals(s)) return true;
            temp.setLength(0);
        }
        return false;
    }
}