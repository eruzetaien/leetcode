class Solution:
    def jump(self, nums: List[int]) -> int:
        n: int = len(nums)
        if (n <= 1):
            return 0

        max_reachable: int = 0
        jump_count_track: Dict[int,int] = {
            max_reachable:0 # max reachable:jump count needed
        }

        for i, jump in enumerate(nums):
            cur_max_reachable = i + jump
            if cur_max_reachable > max_reachable :
                for max_reachable_i in sorted(jump_count_track.keys()):
                    if (max_reachable_i >= i):
                        jump_count_track[cur_max_reachable] = jump_count_track[max_reachable_i] + 1
                        break

                max_reachable = cur_max_reachable

            if max_reachable >= n - 1:
                return jump_count_track[max_reachable]
        
        return -1
        