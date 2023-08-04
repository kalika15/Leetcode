class Solution:
    def makeSubKSumEqual(self, arr: List[int], k: int) -> int:
        N = len(arr)
        visited = [False]*N
        operations = 0
        for i in range(N):
            if visited[i]:
                continue
            visited[i] = True
            group = [arr[i]]
            j = (i+k)%N
            while not visited[j]:
                group.append(arr[j])
                visited[j] = True
                j = (j+k)%N
            group.sort()
            median = group[len(group)//2]
            operations += sum(abs(num-median) for num in group)
        return operations
