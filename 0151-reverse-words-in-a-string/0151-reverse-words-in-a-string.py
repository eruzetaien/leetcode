class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()

        result = ""
        words = s.split()

        for i in range(len(words) -1, -1, -1):
            result += words[i].strip() + " "
        
        return result.strip()
            