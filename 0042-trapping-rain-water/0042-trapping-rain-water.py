class Solution:
    def trap(self, height: List[int]) -> int:
        left=[-1 for i in range(len(height))]
        right=[-1 for i in range(len(height))]
        l=0
        r=0
        for i in range(len(height)):
            left[i]=l
            l=max(l,height[i])
        for i in range(len(height)-1,-1,-1):
            right[i]=r
            r=max(r,height[i])
        ans=0
        for i in range(len(height)):
            temp=min(left[i],right[i])-height[i]
            if temp>0:
                ans+=temp
        return ans
        