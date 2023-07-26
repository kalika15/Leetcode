class MyCalendar:

    def __init__(self):
        self.Events=[]

    def book(self, start: int, end: int) -> bool:
        for i in range(len(self.Events)):
            if (max(start,self.Events[i][0])<min(end, self.Events[i][1])):
                return False
        self.Events.append([start,end])
        return True
            


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)