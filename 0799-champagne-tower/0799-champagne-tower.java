class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] Level=new double[]{poured};

        for(int i=0; i<query_row; i++){
            double[] nextLevel=new double[i+2];
            Arrays.fill(nextLevel, 0.0);

            for(int j=0; j<Level.length; j++){
                double overflow=(Level[j]-1.0)/2.0;
                if(overflow>0.0){
                    nextLevel[j]+=overflow;
                    nextLevel[j+1]+=overflow;
                }
            }
            Level=nextLevel;
        }
        
        return Math.min(1.0, Level[query_glass]);
    }
}