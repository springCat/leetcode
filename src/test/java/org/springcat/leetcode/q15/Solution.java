package org.springcat.leetcode.q15;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
		if(nums ==null || nums.length <3){
			return new ArrayList<>();
		}
		Set<List<Integer>> result = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0){
						System.out.println("i:"+i+" j:"+j+" k:"+k);
						List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(integers);
						result.add(integers);
					}
				}
			}
		}
		return new ArrayList<>(result);
    }

    @Test
    public void test1(){
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
//		[
//		  [-1, 0, 1],
//		  [-1, -1, 2]
//		]
	}
}