package org.springcat.leetcode.q4;

import org.junit.Test;

/**
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		int[] result = new int[len];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < nums1.length && j < nums2.length && k <= len/2){
			if (nums1[i] < nums2[j]) {
				result[k] = nums1[i];
				i++;
			} else {
				result[k] = nums2[j];
				j++;
			}
			k++;
		}
		while (i < nums1.length && k <= len/2){
			result[k] = nums1[i];
			i++;
			k++;
		}
		while (j < nums2.length && k <= len/2){
			result[k] = nums2[j];
			j++;
			k++;
		}
		int sum =result[len / 2] + result[(len - 1)/2];
		return sum/2.0;
	}

	@Test
	public void test(){
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
		System.out.println(medianSortedArrays);
	}
}