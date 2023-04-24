class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int k=0;
        for(int i: nums){
            if(i==1) c++;
            else{
                k=Math.max(k,c);
                c=0;
            }
        }
        if(c!=0) k=Math.max(k,c);
        return k;
    }
}