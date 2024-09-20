import heapq
class Solution:
    def minimumSteps(self, s: str) -> int:
        black_indices = [] #1, min heap
        white_indices = [] #0, max heap

        for index, char in enumerate(s):
            if char == '1':
                black_indices.append(index)
            elif char == '0':
                white_indices.append(-int(index))

        heapq.heapify(white_indices)
        heapq.heapify(black_indices)

        swap_counter = 0
        while ( white_indices and black_indices and (-white_indices[0] > black_indices[0])):
            white_index = -heapq.heappop(white_indices)
            black_index = heapq.heappop(black_indices)
            heapq.heappush(white_indices, -black_index)
            heapq.heappush(black_indices, white_index)
            swap_counter += white_index - black_index

        return swap_counter
        