class Solution {
    public int numTrees(int n) {
        int a=solve(1,n);
        return a;
    }
    public int solve(int i,int j){
        if(i>=j) return 1;
        int a=0;
        for(int round=i;round<=j; round++){
            a+=solve(i,round-1)*solve(round+1,j);
        }
        return a;
    }
}