class Solution {
    int[] dp;
    public int dfs(int i, int[] nums,  HashSet<Integer> set){
        if(dp[i]!=-1) return dp[i];
        int count=1;
        set.add(i);
        if(!set.contains(nums[i])) count+=dfs(nums[i], nums, set);
        dp[i]=count;
        return count;
    }
    public int arrayNesting(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int i=0;
        int count=0;
        while(i<nums.length){
            HashSet<Integer> set=new HashSet<>();
            count=dfs(i, nums, set);
            map.put(i, count);
            i++;
        }
        int max=0;
        for(int key: map.keySet()){
            max=Math.max(max, map.get(key));
        }

        // System.out.print(map);
        return max;
    }
}