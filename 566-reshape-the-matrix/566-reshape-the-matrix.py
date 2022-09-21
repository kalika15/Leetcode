class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        ans=[[0 for i in range(c)]for i in range(r)]
        i=0
        if len(mat)*len(mat[0])!=r*c:
            return mat
        while i<r*c:
            ans[i//c][i%c]=mat[i//len(mat[0])][i%len(mat[0])]
            i+=1
        return ans
                    