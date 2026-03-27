package leetcode.day_01;

public class LC_026_removeDuplicates {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3,4,5,5,5,6,6};
        int length=removeDuplicates(arr);
        System.out.println(length);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        while (right < n) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
