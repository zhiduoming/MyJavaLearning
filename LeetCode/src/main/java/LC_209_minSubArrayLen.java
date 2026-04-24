public class LC_209_minSubArrayLen {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1,1,1,1};
        int length=minSubArrayLen(7,nums);
        System.out.println(length);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        int result=Integer.MAX_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                int currentlength=right-left+1;
                result =Math.min(result,currentlength);
                sum-=nums[left];
                left++;
            }
            right++;
        }

        return result==Integer.MAX_VALUE? 0:result;

    }
}
