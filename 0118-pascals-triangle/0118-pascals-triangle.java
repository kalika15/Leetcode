class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int r=1; r<numRows; r++){
            List<Integer> newRow=new ArrayList<>();
            List<Integer> prevRow=triangle.get(r-1);
            newRow.add(1);
            for(int j=1; j<r; j++){
                newRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle;
    }
}