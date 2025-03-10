class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        result = []
        current_line = []
        current_length = 0

        for word in words:
            # include len(current_line) to count spaces between words 
            if current_length + len(current_line) + len(word) <= maxWidth:
                current_line.append(word)
                current_length += len(word)
            else:
                result.append(self.justifyLine(current_line, current_length, maxWidth))
                # Start a new line with the current word
                current_line = [word]
                current_length = len(word)

        # Handle the last line (left-justified)
        last_line = " ".join(current_line)
        last_line += " " * (maxWidth - len(last_line))
        result.append(last_line)

        return result

    def justifyLine(self, words: List[str], current_length: int, maxWidth: int) -> str:
        if len(words) == 1:
            return words[0] + " " * (maxWidth - len(words[0]))

        total_spaces = maxWidth - current_length

        gaps = len(words) - 1

        base_spaces = total_spaces // gaps
        extra_spaces = total_spaces % gaps

        justified_line = ""
        for i in range(len(words)):
            justified_line += words[i]
            if i < gaps:
                justified_line += " " * base_spaces
                if i < extra_spaces:
                    justified_line += " "

        return justified_line
        