class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        c=0
        if len(flowerbed)==1 and flowerbed[0]==0:
            c+=1
            flowerbed[0]=1
        for i in range(0,len(flowerbed)):
            if i==0 and flowerbed[i]==0 and flowerbed[i+1]==0:
                c+=1
                flowerbed[i]=1
            elif i==len(flowerbed)-1 and flowerbed[i]==0 and flowerbed[i-1]==0:
                c+=1
                flowerbed[i]=1
            elif flowerbed[i]==0 and flowerbed[i-1]==0 and flowerbed[i+1]==0:
                c+=1
                flowerbed[i]=1
        print(c)    
        if c>=n:
            return True
        return False
        