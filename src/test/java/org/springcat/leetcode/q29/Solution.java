package org.springcat.leetcode.q29;

import org.junit.Assert;
import org.junit.Test;

/**
 *给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public int divide(int dividend, int divisor) {

		if (divisor == 0)
			return 0;
		if (divisor == 1)
			return dividend;
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int signdiff = (dividend>0? 1:0) ^ (divisor>0? 1:0);

		long dividendL = Math.abs((long)dividend);
		long divisorL = Math.abs((long)divisor);
		int result = 0;

		for (int i = 31; i >= 0; i --){
			if ((dividendL >> i) >= divisorL){
				result += 1 << i;
				dividendL -= divisorL << i;
			}
		}
		return signdiff ==1 ? -result : result;
    }

    @Test
    public void test1(){
		int divide = divide(10, 3);
		Assert.assertEquals(3,divide);
	}

    @Test
    public void test2(){
		int divide = divide(7, -3);
		Assert.assertEquals(-2,divide);
	}

    @Test
	public void test3(){
		int divide = divide(2, -3);
		Assert.assertEquals(0,divide);
	}

    @Test
	public void test4(){
		int divide = divide(-10, -3);
		Assert.assertEquals(3,divide);
	}

    @Test
	public void test5(){
		int divide = divide(1, 1);
		Assert.assertEquals(1,divide);
	}

	@Test
	public void test6(){
		int divide = divide(-2147483648, -1);
		Assert.assertEquals(2147483647,divide);
	}

	@Test
	public void test7(){
		int divide = divide(2, 2);
		Assert.assertEquals(1,divide);
	}

	@Test
	public void test8(){
		System.out.println(536870913 >>4);
		int divide = divide(-1, 1);
		Assert.assertEquals(-1,divide);
	}
}