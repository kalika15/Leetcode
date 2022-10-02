class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        M = 10 ** 9 + 7

        @lru_cache(None)
        def helper(n, target):
            if n == 0 and target == 0:
                return 1
            if n == 0 or target < 0:
                return 0
            
            return sum(helper(n - 1, target - i) for i in range(1, k + 1)) % M
        
        return helper(n, target)
                
            