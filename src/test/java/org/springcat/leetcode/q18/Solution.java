package org.springcat.leetcode.q18;

import org.junit.Test;

import java.util.*;

/**
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int nowTarget =  target - nums[i];
			List<List<Integer>> lists = threeSum(nums, i + 1, nowTarget);
			if(lists.size() > 0){
				for (List<Integer> list : lists) {
					list.add(nums[i]);
					Collections.sort(list);
					result.add(list);
				}
			}
		}
		return new ArrayList<>(result);
    }

	public List<List<Integer>> threeSum(int[] nums,int low,int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums ==null || nums.length <3){
			return result;
		}
		int len = nums.length;
		for (int i = low; i < len ; i++) {
//			if(nums[i] > target) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
			if(i > low && nums[i] == nums[i-1]) continue; // 去重
			int start = i+1;
			int end = len-1;
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				if( sum == target){
					List<Integer> integers = new ArrayList<>();
					integers.add(nums[start]);
					integers.add(nums[i]);
					integers.add(nums[end]);
					result.add(integers);
					while (start<end && nums[start] == nums[start+1]) start++; // 去重
					while (start<end && nums[start] == nums[end-1]) end--; // 去重
					start++;
					end--;
				}else if(sum < target){
					start++;
				}else if(sum > target){
					end--;
				}
			}
		}
		return result;
	}

	@Test
	public void test1(){
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
	}

	@Test
	public void test2(){
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		int target = -11;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
	}

	@Test
	public void test3(){
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		int target = -7;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
	}
}