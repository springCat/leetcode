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
public class Solution3 {
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
//		for (int num : nums) {
//			System.out.print(num + ",");
//		}
//		System.out.println();
		Set<List<Integer>> result = new HashSet<>();

		Map<Integer, Set<int[]>> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				int num = nums[i] + nums[j];

				int[] ints = {i,j};
				Set<int[]> ints1 = map.get(num);
				if(ints1 == null){
					ints1 = new HashSet<>();
				}
				ints1.add(ints);
//				System.out.printf("put i: %d value:%d  j::%d value:%d, sum:%d \r\n",i,nums[i],j,nums[j],num);
				map.put(num,ints1);

				int need = target - num;
				Set<int[]> integers = map.get(need);

				if(integers != null){
//					System.out.printf("get i:%d value:%d  j::%d value:%d, sum:%d, need %d \r\n",i,nums[i],j,nums[j],num,need);
					for (int[] integer : integers) {
						if(i !=integer[0] && i !=integer[1] && j !=integer[0] && j !=integer[1]){

//							System.out.println("add result i:"+nums[i]+" j:"+nums[j]+" k:"+nums[integer[0]]+" l:"+nums[integer[1]]);
							List<Integer> integers1 = Arrays.asList(nums[i], nums[j], nums[integer[0]], nums[integer[1]]);
							Collections.sort(integers1);
							result.add(integers1);
						}else {
//							System.out.println("ignore result i:"+nums[i]+" j:"+nums[j]+" k:"+nums[integer[0]]+" l:"+nums[integer[1]]);
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

	@Test
	public void test4(){
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		int target = 0;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
		//[
		//		[-3,-2,2,3],
		//		[-3,-1,1,3],
		//		[-3,0,0,3],
		//		[-3,0,1,2],
		//		[-2,-1,0,3],
		//		[-2,-1,1,2],
		//		[-2,0,0,2],
		//		[-1,0,0,1]
		//]
	}

	@Test
	public void test5(){
		int[] nums = {0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
		int target = 6;
		List<List<Integer>> lists = fourSum(nums, target);
		System.out.println(lists);
		//		[
		//		[-10,-2,8,10],
		//		[-9,-3,8,10],
		//		[-9,-2,7,10],
		//		[-9,0,7,8],
		//		[-4,-2,2,10],
		//		[-4,0,2,8],
		//		[-3,0,2,7],
		//		[0,2,2,2]
		//		]
	}

}