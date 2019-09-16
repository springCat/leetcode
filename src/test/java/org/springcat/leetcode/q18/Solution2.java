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
public class Solution2 {
	/**
	 * 2sum
	 * @param nums
	 * @param target
	 * @return
	 */

    public List<List<Integer>> fourSum(int[] nums, int target) {
    	if(nums == null || nums.length < 4){
    		return new ArrayList<>();
		}
    	int len = nums.length;
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				for (int k = j+1; k < len; k++) {
					for (int l = k+1; l < len; l++) {
						if(nums[i]+nums[j] + nums[k]+nums[l] == target){
							result.add(Arrays.asList(nums[i],nums[j] ,nums[k],nums[l]));
						}
					}
				}
			}
		}
		return new ArrayList<>(result);
    }

	@Test
	public void test1(){
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
		//		[
		//  [-1,  0, 0, 1],
		//  [-2, -1, 1, 2],
		//  [-2,  0, 0, 2]
		//]
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