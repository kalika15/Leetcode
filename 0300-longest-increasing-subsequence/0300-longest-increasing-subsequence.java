class Solution {
    public int lengthOfLIS(int[] nums) {
        int size=nums.length;
        int[][] f2tbl=new int[size+1][size];
        int[] f1tbl=new int[size+1];
        f1tbl[0]=0;
        for(int i=0;i<size;i++){
            f2tbl[0][i]=0;
        }
        for(int n=1;n<=size;n++){
            f1tbl[n]=Math.max(f1tbl[n-1],1+f2tbl[n-1][n-1]);
            for(int i=0;i<size;i++){
                f2tbl[n][i]=f2tbl[n-1][i];
                if(nums[n-1]<nums[i]){
                    f2tbl[n][i]=Math.max(f2tbl[n][i],1+f2tbl[n-1][n-1]);
                }
            }
        }
        return f1tbl[size];
    }
}