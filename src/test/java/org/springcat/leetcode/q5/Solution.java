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
public class Solution {
    public String longestPalindrome(String s) {

		for (int l = s.length(); l > 0; l--) {
			for (int i = 0; i < s.length()-l+1; i++) {
				if(isPalindrome(s,i,i+l-1)){
					return s.substring(i,i+l);
				}
			}
		}
		return s;
    }

    public boolean isPalindrome(String s,int i,int j){
		while (i < j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	@Test
	public void test(){
		String s = "babad";
		String s1 = longestPalindrome(s);
		Assert.assertEquals(s1,"bab");
	}

	@Test
	public void test2(){
		String s = "cbbd";
		String s1 = longestPalindrome(s);
		Assert.assertEquals(s1,"bb");
	}

	@Test
	public void test3(){
		String s = "";
		String s1 = longestPalindrome(s);
		Assert.assertEquals(s1,"");
	}

}