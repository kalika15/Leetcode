class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        c=0
        i=0
        j=len(people)-1
        while i<=j:
            if people[i]+people[j]<=limit:
                c+=1
                i+=1
                j-=1
            else:
                if people[i]+people[j]>limit:
                    j-=1
                    c+=1
        return c
            