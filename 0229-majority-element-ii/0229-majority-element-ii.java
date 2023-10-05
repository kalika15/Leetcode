class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        
        int floor=(int)Math.floor((double)nums.length/3);
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int a=map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],a);
            if(a>floor){
                if(!result.contains(nums[i])) result.add(nums[i]);
            }
        }
        return result;
    }
}