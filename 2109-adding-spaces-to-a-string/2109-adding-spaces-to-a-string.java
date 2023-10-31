class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int k=0;
        int m=0;
        for(int i=0; i<spaces.length; i++){
            while(k!=spaces[i]){
                if(m<s.length()){
                    sb.append(s.charAt(m));
                    m+=1;
                }
                k+=1;
            }
            sb.append(" ");
        }
        while(m<s.length()){
            sb.append(s.charAt(m));
            m+=1;
        }
        return sb.toString();
    }
}