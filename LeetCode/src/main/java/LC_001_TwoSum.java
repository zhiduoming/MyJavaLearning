import java.util.Arrays;
import java.util.HashMap;

public class LC_001_TwoSum {
    public static void main(String[] args) {
        LC_001_TwoSum obj = new LC_001_TwoSum();
        int[] res = obj.twoSum(new int[]{2, 7, 11, 15}, 26);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
