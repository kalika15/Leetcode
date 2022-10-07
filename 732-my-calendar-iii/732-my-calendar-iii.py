from sortedcontainers import SortedDict
class MyCalendarThree:

    def __init__(self):
        self.d=SortedDict()

    def book(self, start: int, end: int) -> int:
        c=0
        ans=0
        if start not in self.d:
            self.d[start]=1
        else:
            self.d[start]+=1
        if end not in self.d:
            self.d[end]=-1
        else:
            self.d[end]-=1
        for i in self.d:
            c+=self.d[i]
            ans=max(ans,c)
        return ans


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(start,end)