class Solution {
    public void rotate(int[][] array) {
        int n=array.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp=array[i][j];
                array[i][j]=array[j][i];
                array[j][i]=temp;
            }
        }
       for(int i=0; i<n; i++){
           int start=0;
           int end=n-1;
           while(start<end){
               int temp=array[i][start];
               array[i][start]=array[i][end];
               array[i][end]=temp;
               start++;
               end--;
           }
       }
    }
}
