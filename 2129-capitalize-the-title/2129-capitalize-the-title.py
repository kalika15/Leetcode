class Solution:
    def capitalizeTitle(self, title: str) -> str:
        title=title.lower()
        k=title.split(" ")
        for i in range(len(k)):
            if len(k[i])<3:
                k[i]=k[i].lower()
            else:
                k[i]=k[i].title()
        for i in range(1,len(k)):
            k[0]+=" "
            k[0]+=k[i]
        return k[0]
