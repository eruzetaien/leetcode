class Solution:
    def minimumSteps(self, s: str) -> int:
        black_indices = [] 
        white_indices = [] 

        for index, char in enumerate(s):
            if char == '1':
                black_indices.append(int(index))
            elif char == '0':
                white_indices.append(int(index))

        white_pointer = len(white_indices) - 1
        black_pointer = 0

        counter = 0

        while (black_pointer < len(black_indices) and white_pointer >= 0):
            if white_indices[white_pointer] > black_indices[black_pointer]:
                counter += white_indices[white_pointer] - black_indices[black_pointer]
                white_pointer -= 1
                black_pointer += 1
            else:
                break
        return counter
        