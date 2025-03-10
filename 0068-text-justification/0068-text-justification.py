class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        result = []
        current_line = []
        current_length = 0

        for word in words:
            # Check if adding the current word exceeds the maxWidth
            if current_length + len(current_line) + len(word) <= maxWidth:
                current_line.append(word)
                current_length += len(word)
            else:
                # Distribute spaces for the current line
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
            # Left-justify if there's only one word
            return words[0] + " " * (maxWidth - len(words[0]))

        # Calculate total spaces needed
        total_spaces = maxWidth - current_length
        # Calculate the number of gaps between words
        gaps = len(words) - 1
        # Calculate the base spaces and extra spaces
        base_spaces = total_spaces // gaps
        extra_spaces = total_spaces % gaps

        justified_line = ""
        for i in range(len(words)):
            justified_line += words[i]
            if i < gaps:
                # Add base spaces
                justified_line += " " * base_spaces
                # Add extra spaces (if any)
                if i < extra_spaces:
                    justified_line += " "

        return justified_line
        