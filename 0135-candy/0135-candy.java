class Solution {
    public int candy(int[] ratings) {
        int[] NumberCandy=new int[ratings.length];
        Arrays.fill(NumberCandy,1);
        int answer=0;
        for(int i=1; i<ratings.length; i++){
          if(ratings[i-1]<ratings[i]){
            NumberCandy[i]=NumberCandy[i-1]+1;
          }
        }
        for(int i=ratings.length-2; i>=0; i--){
          if(ratings[i+1]<ratings[i]){
            NumberCandy[i]=Math.max(NumberCandy[i],NumberCandy[i+1]+1);
          }
        }
        for(int ele: NumberCandy){
          System.out.print(ele);
          answer+=ele;
        }
        return answer;
    }
}