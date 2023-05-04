class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        temp1=set()
        temp2=set()
        for i in range(len(nums1)):
            if nums1[i] not in nums2:
                temp1.add(nums1[i])
        for i in range(len(nums2)):
            if nums2[i] not in nums1:
                temp2.add(nums2[i])
        result.append(list(temp1))
        result.append(list(temp2))
        return result