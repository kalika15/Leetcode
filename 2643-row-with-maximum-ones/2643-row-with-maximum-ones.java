class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0; i<mat.length; i++){
            int count=0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1) count++;
            }
            max=Math.max(max,count);
            map.put(i, count);
        }
        int smallestKey=Integer.MAX_VALUE;
        for(int key : map.keySet()){
            if(max==map.get(key)){
                if(smallestKey>key){
                    smallestKey=key;
                }
            }
        }

        return new int[]{smallestKey, max};
    }
}