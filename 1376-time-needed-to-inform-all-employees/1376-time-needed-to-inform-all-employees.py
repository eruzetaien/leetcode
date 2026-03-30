class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        subordinates: List[List[int]] = [[] for _ in range(n)]

        for i in range(n):
            curr_manager: int = manager[i]
            if curr_manager == -1:
                continue

            subordinates[curr_manager].append(i)

        total_time: int = 0
        queue: List[(int, int)] = [(headID,0)] # (person, last_inform_time)
        while (queue):
            manager, last_inform_time = queue.pop(0)
            last_inform_time += informTime[manager]
            total_time = max(total_time, last_inform_time)

            for sub in subordinates[manager]:
                queue.append((sub, last_inform_time))

        return total_time
