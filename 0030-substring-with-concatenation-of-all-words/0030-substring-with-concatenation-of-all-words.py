class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []

        word_length = len(words[0])
        num_words = len(words)
        total_length = word_length * num_words
        word_count = Counter(words)  
        result = []

        for i in range(word_length):
            left, right = i, i
            curr_count = Counter()
            while right + word_length <= len(s):
                word = s[right:right + word_length]  # Ambil kata dari substring
                right += word_length

                if word in word_count:
                    curr_count[word] += 1

                    while curr_count[word] > word_count[word]:
                        curr_count[s[left:left + word_length]] -= 1
                        left += word_length

                    if right - left == total_length:
                        result.append(left)
                else:
                    curr_count.clear()
                    left = right  # Reset window

        return result