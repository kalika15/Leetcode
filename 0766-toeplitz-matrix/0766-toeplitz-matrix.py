class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        for i in range(len(matrix)-2,-1,-1):
            curr=matrix[i][0]
            r=i
            c=0
            while r<len(matrix) and c<len(matrix[0]):
                if curr!=matrix[r][c]:
                    return False
                r+=1
                c+=1
        for i in range(1,len(matrix[0])):
            curr=matrix[0][i]
            r=0
            c=i
            while r<len(matrix) and c<len(matrix[0]):
                if curr!=matrix[r][c]:
                    return False
                r+=1
                c+=1
        return True