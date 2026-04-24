public class LC_004_FindMedianSortArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {10, 14};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        //定义两个指针来分别指向两个数组的首位，按照从小到大的顺序将其中元素放到大数组arr中，同时注意指针更新
        int ptr1 = 0;
        int ptr2 = 0;
        int k = 0;
        while ((ptr1 < nums1.length && ptr2 < nums2.length)) {
            if (nums1[ptr1] < nums2[ptr2]) {
                arr[k++] = nums1[ptr1++];
            } else {
                arr[k++] = nums2[ptr2++];
            }
        }
        //若比对完，则将剩下元素全部放到arr中
        while (ptr1 < nums1.length){
            arr[k++]=nums1[ptr1++];
        }
        while (ptr2 < nums2.length){
            arr[k++]=nums2[ptr2++];
        }

            //得到大数组之后从两边往中间归并
            int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            left++;
            right--;
        }
        double s=arr[left]+arr[right];
        return s/2;
    }

}
