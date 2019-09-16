package org.springcat.leetcode.q16;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		int actual = nums[0]+nums[1]+nums[2];
		for (int i = 0; i < len; i++) {
			int start = i+1;
			int end = nums.length -1;
			while (start < end){
				int sum = nums[start] + nums[end] + nums[i];
				int temp = target - sum;
				if(Math.abs(temp) < Math.abs(target - actual)){
					actual = sum;
				}
				if(temp == 0){
					return sum;
				} else if(temp > 0){
					start ++;
				}else if(temp < 0){
					end--;
				}
			}
		}
		return  actual;
    }

    @Test
    public void test1(){
		int[] nums = {-1,2,1,-4};
		int target = 1;
		int i = threeSumClosest(nums, target);
		Assert.assertEquals(2,i);
	}

    @Test
    public void test2(){
		int[] nums = {0,1,2};
		int target = 0;
		int i = threeSumClosest(nums, target);
		Assert.assertEquals(3,i);
	}

    @Test
    public void test3(){
		int[] nums = {-3,-2,-5,3,-4};
		int target = -1;
		int i = threeSumClosest(nums, target);
		Assert.assertEquals(-2,i);
	}
}