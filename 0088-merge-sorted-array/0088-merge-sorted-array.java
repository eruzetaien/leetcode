class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0; i < n; i++){nums1[i] = nums2[i];}
            return;
        }
        if (n == 0){return;}

        int insertPointer = m + n - 1;  
        int pointer1 = m-1;
        int pointer2 = n-1;

        while (pointer1 >= 0 && pointer2 >= 0){
            if (nums2[pointer2] > nums1[pointer1]){
                nums1[insertPointer] = nums2[pointer2];
                pointer2--;
            } else {
                nums1[insertPointer] = nums1[pointer1];
                pointer1--;
            }
            insertPointer--;
        }

        while (pointer2 >=  0){
            nums1[insertPointer] = nums2[pointer2];
            pointer2--;
            insertPointer--;
        }
    }
}