class Solution:
    def romanToInt(self, s: str) -> int:
        roman_to_int : Dict[str: int] = {
            'I' : 1,
            'V' : 5,
            'X' : 10,
            'L' : 50,
            'C' : 100,
            'D' : 500,
            'M' : 1000
        }
        total : int = 0
        for i in range(len(s)-1):
            prev : int = roman_to_int[s[i]]
            next : int = roman_to_int[s[i+1]]
            if prev >= next:
                total += prev
            else :
                total -= prev
        total += roman_to_int[s[len(s)-1]]

        return total