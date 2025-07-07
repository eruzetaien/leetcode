class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        phone_map = {
            '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
            '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'
        }

        result = []

        def backtrack(digit_idx, combinations):
            if (digit_idx == len(digits)):
                result.append("".join(combinations))
                return
            
            digit = digits[digit_idx]
            posible_char = phone_map[digit]
            for char in  posible_char:
                backtrack(digit_idx + 1, combinations + [char])

        
        backtrack(0, [])
        return result