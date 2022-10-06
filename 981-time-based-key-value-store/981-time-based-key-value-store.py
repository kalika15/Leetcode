class TimeMap:

    def __init__(self):
        self.d=collections.defaultdict(list)
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.d[key].append((timestamp,value))
        

    def get(self, key: str, timestamp: int) -> str:
        i = bisect.bisect_right(self.d[key], timestamp, key=lambda x: x[0])
        return self.d[key][i - 1][1] if i else ''


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)