class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        letter_counts = {}
    
        for letter in magazine:
            if letter in letter_counts:
                letter_counts[letter] += 1
            else:
                letter_counts[letter] = 1
        
        for letter in ransomNote:
            if letter in letter_counts and letter_counts[letter] > 0:
                letter_counts[letter] -= 1
            else:
                return False
        
        return True