class Solution {
    public int numTrees(int n){
        return numberofbst(1,n);
        
    }
    public int numberofbst(int start,int end){
        if(start>=end){
            return 1;
        }
        int ways=0;
        for(int i=start;i<=end;i++){
            ways+=numberofbst(start,i-1)*numberofbst(i+1,end);
        }
        return ways;
    }
}