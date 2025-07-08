class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        result = []

        def backtrack(total, combination):
            if (total > n ):
                return

            if (len(combination) == k):
                if (total == n):
                    result.append(combination)
                return

            last_num = 0
            if (len(combination) > 0):
               last_num = combination[-1]

            for num in range(last_num + 1, 10):
                backtrack(total+num, combination + [num])
        
        backtrack(0,[])

        return result
