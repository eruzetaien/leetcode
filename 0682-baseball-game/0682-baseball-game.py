class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack : List[int] = []
        for op in operations:
            if op == '+': 
                score1 = stack[-1]
                score2 = stack[-2]
                stack.append(score1 + score2)
            elif op == 'D':
                score = stack[-1]
                stack.append(score * 2)
            elif op == 'C':
                _ = stack.pop()
            else:
                stack.append(int(op))
        return sum(stack)