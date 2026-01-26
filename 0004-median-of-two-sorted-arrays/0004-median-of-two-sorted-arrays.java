class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int ptr1 = 0;
        int ptr2 = 0;

        int[] mergedArray = new int[m+n];
        int mergeIdx = 0;
        while (ptr1 < m && ptr2 < n){
            if (nums1[ptr1] <= nums2[ptr2]){
                mergedArray[mergeIdx] = nums1[ptr1];
                ptr1++;
            } else {
                mergedArray[mergeIdx] = nums2[ptr2];
                ptr2++;
            }
            mergeIdx++;
        }

        while (ptr1 < m){
            mergedArray[mergeIdx] = nums1[ptr1];
            ptr1++;
            mergeIdx++;
        }

        while (ptr2 < n){
            mergedArray[mergeIdx] = nums2[ptr2];
            ptr2++;
            mergeIdx++;
        }

        int totalSize = mergedArray.length;
        if (totalSize % 2 == 1) {
            return mergedArray[totalSize / 2];
        } else {
            return (mergedArray[totalSize / 2 - 1] + mergedArray[totalSize / 2]) / 2.0;
        }

    }
}