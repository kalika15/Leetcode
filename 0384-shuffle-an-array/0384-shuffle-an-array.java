class Solution {
    int[] original;
    Random rand=new Random();
    public Solution(int[] nums) {
        original=nums;
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        List<Integer> temp=new ArrayList<>();
        for(int nums: original){
            temp.add(nums);
        }
        List<Integer> res=new ArrayList<>();
        while(!temp.isEmpty()){
            int idx=rand.nextInt(temp.size());
            res.add(temp.get(idx));
            temp.set(idx, temp.get(temp.size()-1));
            temp.remove(temp.size()-1);
        }
        int[] result=new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i]=res.get(i);
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */