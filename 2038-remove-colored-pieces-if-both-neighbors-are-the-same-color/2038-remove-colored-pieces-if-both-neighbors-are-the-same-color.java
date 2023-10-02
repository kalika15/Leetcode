class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        int alice=0;
        int bob=0;
        for(int i=1; i<n-1; i++){
            if(colors.charAt(i-1)=='A' && colors.charAt(i)=='A' && colors.charAt(i+1)=='A'){
                alice++;
            }
            else if(colors.charAt(i-1)=='B' && colors.charAt(i)=='B' && colors.charAt(i+1)=='B'){
                bob++;
            }
        }
        if(alice>bob) return true;
        return false;
    }
}