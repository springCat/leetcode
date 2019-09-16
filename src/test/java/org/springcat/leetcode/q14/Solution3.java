package org.springcat.leetcode.q14;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
		if (l == r) {
			return strs[l];
		}
		else {
			int mid = (l + r)/2;
			String lcpLeft =   longestCommonPrefix(strs, l , mid);
			String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	String commonPrefix(String left,String right) {
		int min = Math.min(left.length(), right.length());
		for (int i = 0; i < min; i++) {
			if ( left.charAt(i) != right.charAt(i) )
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}

	@Test
	public void test1(){
		String[] strings = {"flower","flow","flight"};
		String s = longestCommonPrefix(strings);
		Assert.assertEquals("fl",s);
	}

	@Test
	public void test2(){
		String[] strings = {"dog","racecar","car"};
		String s = longestCommonPrefix(strings);
		Assert.assertEquals("",s);
	}

}