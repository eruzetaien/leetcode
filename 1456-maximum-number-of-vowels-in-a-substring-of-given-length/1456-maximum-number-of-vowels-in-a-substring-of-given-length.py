class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = ['a','i','u','e','o']
        max_vowel_count = 0
    
        far_left_idx = 0
        vowel_count = 0
        letter_count = 0
        for i in range(len(s)):
            letter_count += 1
            if (s[i] in vowels):
                vowel_count += 1

            if (letter_count == k):
                if (vowel_count > max_vowel_count):
                    max_vowel_count = vowel_count

                if (s[far_left_idx] in vowels):
                    vowel_count -= 1  

                letter_count -= 1
                far_left_idx += 1
        
        return max_vowel_count