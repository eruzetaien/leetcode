class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        diffs = []
        total_cost = 0

        for i in range(len(gas)):
            diffs.append(gas[i] - cost[i])
            total_cost += diffs[i]

        if (total_cost < 0):
            return -1

        start_idx = 0
        total_cost = 0
        for i in range (len(diffs)):
            total_cost += diffs[i]
            if (total_cost < 0):
                start_idx = i + 1
                total_cost = 0

        return start_idx