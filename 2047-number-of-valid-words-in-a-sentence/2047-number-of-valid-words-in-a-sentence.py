class Solution:
    def countValidWords(self, sentence: str) -> int:
        hyphenCount=0
        wordCount=0
        number=['0','1','2','3','4','5','6','7','8','9']
        alphabet=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
        l=sentence.split(' ')
        for i in range(len(l)):
            if l[i]==' ':
                l.remove(l[i])
        
        for i in range(len(l)):
            hyphenCount=0
            for j in range(len(l[i])):
                if l[i][j]=='-':
                    hyphenCount+=1
                    if hyphenCount==1 and j-1>=0 and j+1<=len(l[i])-1 and l[i][j-1] in alphabet and l[i][j+1] in alphabet:
                        continue
                    # if hyphenCount>1 or j==0 or j==len(l[i])-1:
                    #     break
                    else:
                        break

                if l[i][j]=='.' or l[i][j]=='!' or l[i][j]==',':
                    if j!=len(l[i])-1:
                        break
                if l[i][j] in number:
                    break
                if j==len(l[i])-1:
                    wordCount+=1
                    print(l[i])
        return wordCount
                
