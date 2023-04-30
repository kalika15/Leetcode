class Solution {
    public int arraySign(int[] nums) {
        int positiveCount=0;
        int negativeCount=0;
        for(int i:nums){
            if(i>0){
                positiveCount+=1;
            }
            else if (i<0){
                negativeCount+=1;
            }
            else if(i==0){
                return 0;
            }
        }
        if(negativeCount%2==0){
            return 1;
        }
        return -1;
    }
}