class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m-1;
        int pointer2 = n-1;
        int insertPointer = m+n-1;

        while (pointer2 >= 0 && pointer1 >=0) {
            int num1 = nums1[pointer1];
            int num2 = nums2[pointer2];
            if (num1 >= num2){
                nums1[insertPointer] = num1;
                pointer1--;
            } else {
                nums1[insertPointer] = num2;
                pointer2--;
            }
            insertPointer--;
        }

        while (pointer2 >= 0) {
            nums1[insertPointer] = nums2[pointer2];
            pointer2--;
            insertPointer--;
        }
    }
}