package org.springcat.leetcode.q6;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {
	/**
	 * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
	 *
	 * 对于所有整数 kk，
	 *
	 * 行 00 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2) 处;
	 * 行 \text{numRows}-1numRows−1 中的字符位于索引 k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1 处;
	 * 内部的 行 ii 中的字符位于索引 k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i 以及 (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i 处;
	 *
	 * @param s
	 * @param numRows
	 * @return
	 */
    public String convert(String s, int numRows) {
		if (numRows == 1) return s;

		StringBuilder ret = new StringBuilder();
		int n = s.length();
		int cycleLen = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
					ret.append(s.charAt(j + cycleLen - i));
			}
		}
		return ret.toString();
	}

	@Test
	public void test(){
		String s = "LEETCODEISHIRING";
		String convert = convert(s, 4);
		Assert.assertEquals("LDREOEIIECIHNTSG",convert);
	}

	@Test
	public void test2(){
		String s = "";
		String convert = convert(s, 1);
		Assert.assertEquals("",convert);
	}

	@Test
	public void test3(){
		String s = "AB";
		String convert = convert(s, 1);
		Assert.assertEquals("AB",convert);
	}
}