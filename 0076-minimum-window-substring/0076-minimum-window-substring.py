class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""
        
        dict_t = {}
        for char in t:
            dict_t[char] = dict_t.get(char, 0) + 1
        
        required = len(dict_t)
        formed = 0
        window_counts = {}
        
        ans = float('inf'), None, None  # (window length, left, right)
        left = 0
        for right, char in enumerate(s):
            window_counts[char] = window_counts.get(char, 0) + 1
            
            if char in dict_t and window_counts[char] == dict_t[char]:
                formed += 1
            
            while left <= right and formed == required:
                current_len = right - left + 1 
                if  current_len < ans[0]:
                    ans = (current_len, left, right)
                
                char_left = s[left]
                window_counts[char_left] -= 1
                if char_left in dict_t and window_counts[char_left] < dict_t[char_left]:
                    formed -= 1
                left += 1
        
        return "" if ans[0] == float('inf') else s[ans[1]:ans[2]+1]