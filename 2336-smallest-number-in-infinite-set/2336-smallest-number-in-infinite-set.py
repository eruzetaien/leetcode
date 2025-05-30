class SmallestInfiniteSet:

    def __init__(self):
        self.current = 1
        self.added_back = set()
        self.heap = []

    def popSmallest(self) -> int:
        if (self.heap):
            min = heapq.heappop(self.heap)
            self.added_back.remove(min)
            return min
        else :
            min = self.current
            self.current += 1
            return min

    def addBack(self, num: int) -> None:
        if (num < self.current and num not in self.added_back):
            heapq.heappush(self.heap, num)
            self.added_back.add(num)
       


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)