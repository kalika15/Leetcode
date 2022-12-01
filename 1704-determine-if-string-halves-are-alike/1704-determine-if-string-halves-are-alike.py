class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n=len(s)//2
        a=s[:n]
        b=s[n:]
        l=['a','e','i','o','u','A','E','I','O','U']
        da={}
        for i in range(len(a)):
            if a[i] in l and a[i] in da:
                da[a[i]]+=1
            elif a[i] in l and a[i] not in da:
                da[a[i]]=1
        db={}
        for i in range(len(b)):
            if b[i] in l and b[i] in db:
                db[b[i]]+=1
            elif b[i] in l and b[i] not in db:
                db[b[i]]=1
        sa=sum(list(da.values()))
        sb=sum(list(db.values()))
        if sa==sb:
            return True
        return False