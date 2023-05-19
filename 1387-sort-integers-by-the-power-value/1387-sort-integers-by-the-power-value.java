class Solution {
    Map<Integer,Integer> dp=new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        int[][] power=new int[hi-lo+1][2];
        int index=0;
        for(int i=lo; i<=hi; i++){
            power[index][0]=i;
            power[index][1]=calculatePower(i);
            index+=1;
        }
        Arrays.sort(power,(a,b)-> a[1]-b[1]);
        return power[k-1][0];
    }
    private int calculatePower(int num){
        if(num==1) return 0;
        if(dp.containsKey(num)) return dp.get(num);
        int step=0;
        if(num%2==0){
            step=1+calculatePower(num/2);
        }
        else{
            step=1+calculatePower(num*3+1);
        }
        dp.put(num,step);
        return step;
    }
}