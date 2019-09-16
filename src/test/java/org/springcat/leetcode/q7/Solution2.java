package org.springcat.leetcode.q7;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
    public int reverse(int x) {
		boolean flag = false;
		if(x < 0){
			x = -x;
			flag =true;
		}
		int result = 0;
		int maxlimit = Integer.MAX_VALUE / 10;
		while (x > 0){
			if(result > maxlimit){
				return 0;
			}
			result *= 10;

			int i = x % 10;
			if( Integer.MAX_VALUE - i < result){
				return 0;
			}
			result += i;

			x = x/10;
		}
		return flag? -result:result;
	}

	@Test
	public void test(){
		int reverse = reverse(-1234);
		Assert.assertEquals(-4321,reverse);
	}


	@Test
	public void test2(){
		int reverse = reverse(1534236469);
		Assert.assertEquals(0,reverse);
	}

	@Test
	public void test3(){
		int reverse = reverse(-2147483648);
		Assert.assertEquals(0,reverse);
	}

	@Test
	public void test4(){
		int reverse = reverse(-2147483412);
		Assert.assertEquals(-2143847412,reverse);
	}
}