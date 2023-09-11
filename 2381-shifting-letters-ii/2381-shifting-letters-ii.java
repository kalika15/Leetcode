class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // String result="";
        char[] character=s.toCharArray();
        int[] res=new int[s.length()];
        for(int[] shift: shifts){
            int start=shift[0];
            int end=shift[1];
            int direction=shift[2];
            if(direction==1){
                for(int i=start; i<=end; i++){
                    res[i]++;
                }
            }
            else{
                for(int i=start; i<=end; i++){
                    res[i]--;
                }
            }
            
        }

        for(int i=0; i<s.length(); i++){
            int newchar=((s.charAt(i)-'a')+res[i])%26;
           if(newchar<0) newchar+=26;
           character[i]=(char)(newchar+'a');
        }
        
        return String.valueOf(character);

    }
}