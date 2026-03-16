class Solution:
    def addBinary(self, a: str, b: str) -> str:
        reminder: int = 0

        i:int = len(a) - 1
        j:int = len(b) - 1

        stack: List[int] = []
        while (i >= 0 and j >= 0):
            curr_sum: int = int(a[i]) + int(b[j])
            curr_sum += reminder
            reminder = 0

            if curr_sum >= 2:
                reminder = curr_sum // 2
                curr_sum %= 2
            
            stack.append(curr_sum)
            i -= 1
            j -= 1
        
        while i >= 0:
            curr_sum: int = int(a[i]) + reminder
            reminder = 0
            if curr_sum >= 2:
                reminder = curr_sum // 2
                curr_sum %= 2
            
            stack.append(curr_sum)
            i -= 1

        while j >= 0:
            curr_sum: int = int(b[j]) + reminder
            reminder = 0
            if curr_sum >= 2:
                reminder = curr_sum // 2
                curr_sum %= 2
            
            stack.append(curr_sum)
            j -= 1

        result: str = ""
        if (reminder > 0):
            result += str(reminder)

        while stack:
            result += str(stack.pop())


        return result