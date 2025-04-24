class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        occurrences = dict()

        for num in arr:
            occurrences[num] = occurrences.get(num,0) + 1


        unique_occurrences = set()

        for occurrence in occurrences.values():
            if (occurrence in unique_occurrences):
                return False

            unique_occurrences.add(occurrence) 
        return True
        