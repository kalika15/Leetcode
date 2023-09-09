class Solution {
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=1; i<=target; i++){
            for(int num:nums){
                map.put(i, map.getOrDefault(i,0)+ map.getOrDefault(i-num,0));
            }
        }
        return map.get(target);
    }
}