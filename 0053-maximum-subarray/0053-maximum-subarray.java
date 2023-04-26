import java.util.List;
import java.util.Collections;

class Solution {
    public int maxSubArray(int[] nums) {
        List<Integer> num=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            num.add(nums[i]);
        }
        int ans = Collections.min(num);
        int s = 0;
        for (int i = 0; i < num.size(); i++) {
            s += num.get(i);
            ans = Math.max(s, ans);
            if (s < 0) {
                s = 0;
            }
        }
        return ans;
    }
}