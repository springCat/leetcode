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
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
        	return "";
		}
        String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			prefix = getPrefix(prefix, strs[i]);
			if(prefix.length() == 0){
				return "";
			}
		}
		return prefix;
    }

    public String getPrefix(String s1,String s2){
		StringBuilder stringBuilder = new StringBuilder();
		int len1 = s1.length();
		int len2 = s2.length();
		int i = 0;
		while (i < Math.min(len1,len2)){
			if(s1.charAt(i) == s2.charAt(i)){
				stringBuilder.append(s1.charAt(i));
				i++;
			}else {
				return stringBuilder.toString();
			}
		}
		return stringBuilder.toString();
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

	@Test
	public void test3(){

		System.out.println("".substring(0,0));
	}

}