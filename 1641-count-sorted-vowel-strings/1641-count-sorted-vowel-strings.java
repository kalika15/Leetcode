class Solution {
    public int countVowelStrings(int n) {
        return solve(n,1);
    }
    private int solve(int n,int start){
        if(n==0) return 1;
        int result=0;
        for(int i=start; i<=5; i++){
            result+=solve(n-1,i);
        }
        return result;
    }
}