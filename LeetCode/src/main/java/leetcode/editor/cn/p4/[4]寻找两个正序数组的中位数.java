package leetcode.editor.cn.p4;

import leetcode.editor.cn.common.ListNode;
import leetcode.editor.cn.common.TreeNode;

import java.util.*;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7967 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];

        int p1=0;
        int p2=0;
        int k=0;
        while (p1<nums1.length&&p2<nums2.length){
            if(nums1[p1]<nums2[p2]){
                arr[k++]=nums1[p1++];
            }else {
                arr[k++]=nums2[p2++];
            }
        }
        while (p1<nums1.length){
            arr[k++] = nums1[p1++];
        }
        while (p2<nums2.length){
            arr[k++] = nums2[p2++];
        }

        int left=0;
        int right=arr.length-1;
        while (left<right){
            left++;
            right--;
        }
        return (double) (arr[left]+arr[right])/2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
