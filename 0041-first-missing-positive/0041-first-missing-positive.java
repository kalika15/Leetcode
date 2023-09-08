class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> temp=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            temp.add(nums[i]);
        }
        int i=1;
        while(i<nums.length){
            if(!temp.contains(i)) return i;
            i++;
        }
        if(!temp.contains(i)) return i;
        return i+1;
    }
}