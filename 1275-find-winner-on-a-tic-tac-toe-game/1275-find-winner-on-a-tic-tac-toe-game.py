class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        ans=[["C" for _ in range(3)]for _ in range(3)]
        c=0
        for k , mov in enumerate(moves):
            i=mov[0]
            j=mov[1]
            if k%2==0:
                ans[i][j]='A'
                c+=1
            else:
                ans[i][j]='B'
                c+=1
        for i in range(3):
            if ans[i][0]==ans[i][1]==ans[i][2] and ans[i][0] in ['A','B']:
                return ans[i][0]
            elif ans[0][i]==ans[1][i]==ans[2][i] and ans[0][i] in ['A','B']:
                return ans[0][i]
        if ans[0][0]==ans[1][1]==ans[2][2] and ans[0][0] in ['A','B']:
            return ans[0][0]
        elif ans[0][2]==ans[1][1]==ans[2][0] and ans[0][2] in ['A','B']:
            return ans[0][2]
        if c==9:
            return("Draw")
        else:
            return("Pending")
            