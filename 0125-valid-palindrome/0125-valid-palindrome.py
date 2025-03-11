class Solution:
    def isPalindrome(self, s: str) -> bool:
        if (len(s) <= 1):
            return True

        left_pointer = 0
        right_pointer = len(s) - 1

        while (left_pointer <= right_pointer):
            if (not s[left_pointer].isalnum()):
                left_pointer += 1

                if (not s[right_pointer].isalnum()):
                    right_pointer -= 1
                continue

            if (not s[right_pointer].isalnum()):
                right_pointer -= 1

                if (not s[left_pointer].isalnum()):
                    left_pointer += 1
                continue


            if (s[left_pointer].lower() != s[right_pointer].lower()):
                return False
            
            left_pointer += 1
            right_pointer -= 1

        return True
        
        