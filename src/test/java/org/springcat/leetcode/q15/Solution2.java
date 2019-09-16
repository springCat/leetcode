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
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums ==null || nums.length <3){
			return result;
		}
		int len = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < len ; i++) {
			if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
			if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
			int start = i+1;
			int end = len-1;
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				if( sum == 0){
					result.add(Arrays.asList(nums[start],nums[i],nums[end]));
					while (start<end && nums[start] == nums[start+1]) start++; // 去重
					while (start<end && nums[start] == nums[end-1]) end--; // 去重
					start++;
					end--;
				}else if(sum < 0){
					start++;
				}else if(sum > 0){
					end--;
				}
			}
		}
		return result;
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

	@Test
    public void test2(){
		int[] nums = {0,0,0,0,0};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
		//		[
		//		  [0, 0, 0]
		//		]
	}

	@Test
    public void test3(){
		int[] nums = {1,-1,-1,0};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
		//		[[-1,0,1]]
	}

	@Test
    public void test4(){
		int[] nums = {-2,0,1,1,2};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
//		[
//			[-2,0,2],
//			[-2,1,1]
//		]
	}

	@Test
	public void test5(){
		int[] nums = {-2,-1,-1,0,2};
		List<List<Integer>> lists = threeSum(nums);
		System.out.println(lists);
		//		[
		//			[-2,0,2],
		//			[-1,-1,2]
		//		]
	}
}