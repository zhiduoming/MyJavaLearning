public class LC_080_removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }


    public static int removeDuplicates(int[] nums) {
        int i=0;
        int n=nums.length;
        for (int num : nums) {
            if(i<2||num!=nums[i-2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}