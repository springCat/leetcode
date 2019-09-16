package org.springcat.leetcode.q9;

import org.junit.Assert;
import org.junit.Test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//like q7 resverse
public class Solution {
    public boolean isPalindrome(int x) {
    	int num = x;
        if(x < 0){
        	return false;
		}
		int result = 0;
		int maxlimit = Integer.MAX_VALUE / 10;
		while (x > 0){
			if(result > maxlimit){
				return false;
			}
			result *= 10;

			int i = x % 10;
			if( Integer.MAX_VALUE - i < result){
				return false;
			}
			result += i;

			x = x/10;
		}
		return result == num;
    }

    @Test
    public void test1(){
		boolean palindrome = isPalindrome(121);
		Assert.assertTrue(palindrome);
	}

	@Test
	public void test2(){
		boolean palindrome = isPalindrome(-121);
		Assert.assertFalse(palindrome);
	}

	@Test
	public void test3(){
		boolean palindrome = isPalindrome(10);
		Assert.assertFalse(palindrome);
	}
}