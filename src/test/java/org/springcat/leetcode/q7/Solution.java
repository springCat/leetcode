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
public class Solution {
    public int reverse(int x) {
    	boolean flag = false;
		if(x < 0){
			x = -x;
			flag =true;
		}
		String s = Integer.toString(x);
		char[] chars = s.toCharArray();
		int length = s.length();
		for (int i = 0; i < length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[length-1-i];
			chars[length-1-i] = temp;
		}
		String s1 = new String(chars);
		try {
			int i = Integer.parseInt(s1);
			return  flag ? -i:i;
		}catch (Exception e){
			return 0;
		}
	}

	@Test
	public void test(){
		int reverse = reverse(-1234);
		Assert.assertEquals(-4321,reverse);
	}
}