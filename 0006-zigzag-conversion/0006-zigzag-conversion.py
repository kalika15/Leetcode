class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows==1 or numRows>=len(s):
            return s
        rows=[[] for i in range(numRows)]
        i=0
        step=-1
        for char in s:
            rows[i].append(char)
            if i==0:
                step=1
            elif i==numRows-1:
                step=-1
            i+=step
        for j in range(numRows):
            rows[j]="".join(rows[j])
        return "".join(rows)
