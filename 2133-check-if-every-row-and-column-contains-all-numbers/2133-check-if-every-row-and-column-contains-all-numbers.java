class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        HashMap<Integer,List<Integer>> rowmap=new HashMap<>();
        HashMap<Integer,List<Integer>> colmap=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<Integer> temp=rowmap.getOrDefault(i,new ArrayList<>());
                temp.add(matrix[i][j]);
                rowmap.put(i,temp);
                List<Integer> temp1=colmap.getOrDefault(j,new ArrayList<>());
                temp1.add(matrix[i][j]);
                colmap.put(j,temp1);
            }
        }
        for(Map.Entry<Integer,List<Integer>> k: rowmap.entrySet()){
            List<Integer> temp=k.getValue();
            for(int i=0;i<n;i++){
                if(!temp.contains(i+1)) return false;
            }
        }
        for(Map.Entry<Integer,List<Integer>> k: colmap.entrySet()){
            List<Integer> temp=k.getValue();
             for(int i=0;i<n;i++){
                if(!temp.contains(i+1)) return false;
            }
        }
        return true;
    }
}