package org.springcat.leetcode.q5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {
	public String longestPalindrome(String s) {
		if (s.equals("")) {
			return "";
		}
		int length = s.length();
		String reversal = new StringBuffer(s).reverse().toString(); // 反转字符串
		int[][] cell = new int[length][length];
		int maxLen = 0; // 最长回文子串长度
		int maxEnd = 0; // 最长回文子串结束位置
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (reversal.charAt(i) == s.charAt(j)) {
					if (i == 0 || j == 0) {
						cell[i][j] = 1;
					} else {
						cell[i][j] = cell[i - 1][j - 1] + 1;
					}
				} else {
					cell[i][j] = 0;
			   	}

				if (cell[i][j] > maxLen) {
					int beforeIndex = length - 1 - i; // 反向子串末尾字符的原始索引
					int firstIndex =  j - cell[i][j] + 1; // 子串的首字符索引
					if (beforeIndex == firstIndex) {
						maxLen = cell[i][j];
						maxEnd = j;
					}
				}
			}
		}
		return s.substring(maxEnd + 1 - maxLen, maxEnd + 1);
	}


	@Test
	public void test(){
		String s = "babad";
		String s1 = longestPalindrome(s);
		Assert.assertEquals("bab",s1);
	}

	@Test
	public void test2(){
		String s = "cbbd";
		String s1 = longestPalindrome(s);
		Assert.assertEquals("bb",s1);
	}

	@Test
	public void test3(){
		String s = "";
		String s1 = longestPalindrome(s);
		Assert.assertEquals("",s1);
	}

	@Test
	public void test4(){
		String s = "aaccdefcaa";
		String s1 = longestPalindrome(s);
		Assert.assertEquals("aa",s1);
	}

	@Test
	public void test5(){
		String s = "aacdefcaa";
		String s1 = longestPalindrome(s);
		Assert.assertEquals("aa",s1);
	}

	/**
	 * 	 a a c d e f c a a
	 * a
	 * a
	 * c
	 * f
	 * e
	 * d
	 * c
	 * a
	 * a
 	 */
}