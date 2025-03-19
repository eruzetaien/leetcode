class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index_map = {}  # last index of each character
        max_length = 0
        start = 0  # Start of the sliding window

        for end, char in enumerate(s):
            if char in char_index_map and char_index_map[char] >= start:
                # If the character is repeated and it's within the current window
                start = char_index_map[char] + 1  # Move the start of the window

            # Update the last index of the character
            char_index_map[char] = end

            current_length = end - start + 1
            max_length = max(max_length, current_length)

        return max_length
