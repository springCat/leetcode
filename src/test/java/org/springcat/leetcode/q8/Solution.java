package org.springcat.leetcode.q8;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
	public int myAtoi(String str) {
		if("".equals(str)){
			return 0;
		}
		int i = -1;
		int len = str.length();
		boolean negative = false;
		int result = 0;
		int limit = -Integer.MAX_VALUE;
		int multmin = limit/10;
		int digit;
		boolean findFist = false;
		//find start
		while (i < len-1) {
			i++;
			char firstChar = str.charAt(i);
			if (firstChar == ' ') {

			} else if (firstChar == '-') {
				findFist = true;
				negative = true;
				limit = Integer.MIN_VALUE;
				multmin = limit/10;
				if(len == 1){
					return 0;
				}
				i++;
				break;
			} else if (firstChar == '+') {
				findFist = true;
				if(len == 1){
					return 0;
				}
				i++;
				break;
			} else if (firstChar <= '9' && firstChar >= '0') {
				findFist = true;
				break;
			} else {
				return 0;
			}
		}

		if(!findFist || i == -1){
			return 0;
		}
		//find end
		while (i < len){
			char c = str.charAt(i);
			if(c <= '9' && c>= '0'){
				if(result + multmin > 0){
					return negative ? Integer.MIN_VALUE:Integer.MAX_VALUE;
				}
				result *= 10;

				digit = Character.digit(c,10);
				if(result + limit + digit > 0){
					return negative ? Integer.MIN_VALUE:Integer.MAX_VALUE;
				}
				result += digit;
				i++;
			}else {
				break;
			}
		}
		return negative ? -result:result;
	}

	@Test
	public void test1() {
		int i = myAtoi("42");
		Assert.assertEquals(42, i);
	}

	@Test
	public void test2() {
		int i = myAtoi("   -42");
		Assert.assertEquals(-42, i);
	}

	@Test
	public void test3() {
		int i = myAtoi("4193 with words");
		Assert.assertEquals(4193, i);
	}

	@Test
	public void test4() {
		int i = myAtoi("words and 987");
		Assert.assertEquals(0, i);
	}

	@Test
	public void test5() {
		int i = myAtoi("-91283472332");
		Assert.assertEquals(-2147483648, i);
	}

	@Test
	public void test6() {
		int i = myAtoi("");
		Assert.assertEquals(0, i);
	}

	@Test
	public void test7() {
		int i = myAtoi("   -42");
		Assert.assertEquals(-42, i);
	}

	@Test
	public void test8() {
		int i = myAtoi("3.14159");
		Assert.assertEquals(3, i);
	}

	@Test
	public void test9() {
		int i = myAtoi("+");
		Assert.assertEquals(0, i);
	}

	@Test
	public void test10() {
		int i = myAtoi("    0000000000000   ");
		Assert.assertEquals(0, i);
	}

	@Test
	public void test12() {
		int i = myAtoi("0-1");
		Assert.assertEquals(0, i);
	}


}