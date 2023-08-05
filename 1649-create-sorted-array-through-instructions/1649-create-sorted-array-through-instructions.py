# tle time complexity o(n^2) and space complexity o(n)

class Solution1:
    def createSortedArray(self, instructions: List[int]) -> int:
        nums=[]
        cost=0
        for i in range(len(instructions)):
            lesser=0
            greater=0
            for j in range(len(nums)):
                if instructions[i]>nums[j]:
                    lesser+=1
                elif instructions[i]<nums[j]:
                    greater+=1
            nums.append(instructions[i])
            cost+=min(lesser,greater)
        return cost


#  tle time complexity o(n^2 logn) and space complexity o(n)
class Solution2:

    def MergeSort(self,arr,target):
        if len(arr)>1:
            mid=len(arr)//2
            L=arr[:mid]
            R=arr[mid:]
            self.MergeSort(L,target)
            self.MergeSort(R,target)
            i=0
            j=0
            k=0
            lesser=0
            greater=0
            while i<len(L) and j<len(R):
                if L[i]<=R[j]:
                    arr[k]=L[i]
                    i+=1
                else:
                    arr[k]=R[j]
                    j+=1
                if arr[k]<target:
                    lesser+=1
                elif arr[k]>target:
                    greater+=1
                k+=1
            while i<len(L):
                arr[k]=L[i]
                if arr[k]<target:
                    lesser+=1
                elif arr[k]>target:
                    greater+=1
                i+=1
                k+=1
            while j<len(R):
                arr[k]=R[j]
                if arr[k]<target:
                    lesser+=1
                elif arr[k]>target:
                    greater+=1
                j+=1
                k+=1
            return min(lesser,greater)
        else:
            return 0
    
    def createSortedArray(self, instructions: List[int]) -> int:
        cost=0
        nums=[]
        for i in range(len(instructions)):
            nums.append(instructions[i])
            a=self.MergeSort(nums,instructions[i])
            if(a>0):
                cost+=a
        return cost

# time complexity o(n)

class Solution:
    def __init__(self):
        self.nums=[0]* 100002
    def createSortedArray(self, instructions: List[int]) -> int:   
        cost=0
        for i in range(len(instructions)):
            smaller=self.find(instructions[i]-1)
            larger=i-self.find(instructions[i])
            cost+=min(smaller,larger)
            self.update(instructions[i])
        return cost%(10**9 + 7)

    def update(self,x):
        while(x<100001):
            self.nums[x]+=1
            x+=(x & -x)

    def find(self,x):
        count=0
        while(x>0):
            count+=self.nums[x]
            x-=(x & -x)
        return count

    