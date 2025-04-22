class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        nums1_set = set(nums1)
        nums2_set = set(nums2)

        return [list(nums1_set.difference(nums2_set)), list(nums2_set.difference(nums1_set))]
        