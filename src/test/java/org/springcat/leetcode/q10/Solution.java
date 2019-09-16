package org.springcat.leetcode.q10;

import org.junit.Assert;
import org.junit.Test;

/**
 *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
	/**
	 *
	 * 1
	 *   p\s a a
	 *   a   1 1
	 *         0
	 * 2
	 *   p\s a a
	 *   a   1 1
	 *   *   1 1
	 * 3
	 *   p\s a b
	 *   .   1 1
	 *   *   1 1
	 * 4
	 * 	 p\s a a b
	 * 	  c  0 0 0
	 * 	  *  0 0 0
	 * 	  a  1 1 0
	 * 	  *  1 1 0
	 * 	  b  0 0 1
	 *
	 * 5
	 * p\s m i s s i s s i p p i
	 *   m 1 0 0 0 0 0 0 0 0 0 0
	 *   i 0 1 0 0 1 0 0 1 0 0 1
	 *   s 0 0 1 1 0 1 1 0 0 0 0
	 *   * 0 0 1 1 0 1 1 0 0 0 0
	 *   i 0 1 0 0 1 0 0 1 0 0 1
	 *   s 0 0 1 1 0 1 1 0 0 0 0
	 *   * 0 0 1 1 0 1 1 0 0 0 0
	 *   p 0 0 0 0 0 0 0 0 1 1 0
	 *   * 0 0 0 0 0 0 0 0 1 1 0
	 *   . 1 1 1 1 1 1 1 1 1 1 1
	 */

	public boolean isMatch(String text, String pattern)  {
		return isMatch(text,0,pattern,0);
	}

	public boolean isMatch(String text,int i, String pattern,int j){
		if (j == pattern.length()){
			return i == text.length();
		}
		//i 匹配完成后，不再进行i递增多运算
		boolean first_match = false;
		if(i < text.length()) {
			first_match = (!text.isEmpty() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
		}
		//处理1一个字符为*时
		if ( j < pattern.length()-1  && pattern.charAt(j+1) == '*'){
			//认为*为空时，消除掉前面掉字符
			return (isMatch(text,i, pattern,j+2) ||
					//当前字符匹配到字符了，*多匹配几个字符
					(first_match && isMatch(text,i+1, pattern,j)));
		} else {
			//正常处理下一个
			return first_match && isMatch(text,i+1, pattern,j+1);
		}
	}

	@Test
	public void test1(){
		String s = "aa";
		String p = "a";
		boolean match = isMatch(s, p);
		Assert.assertEquals(false,match);
	}

	@Test
	public void test2(){
		String s = "aa";
		String p = "a*";
		boolean match = isMatch(s, p);
		Assert.assertEquals(true,match);
	}

	@Test
	public void test3(){
		String s = "ab";
		String p = ".*";
		boolean match = isMatch(s, p);
		Assert.assertEquals(true,match);
	}

	@Test
	public void test4(){
		String s = "aab";
		String p = "c*a*b";
		boolean match = isMatch(s, p);
		Assert.assertEquals(true,match);
	}

	@Test
	public void test5(){
		String s = "mississippi";
		String p = "mis*is*p*.";
		boolean match = isMatch(s, p);
		Assert.assertEquals(false,match);
	}

	@Test
	public void test6(){
		String s = "ab";
		String p = ".*c";
		boolean match = isMatch(s, p);
		Assert.assertEquals(false,match);
	}

	@Test
	public void test7(){
		String s = "a";
		String p = ".*..a*";
		boolean match = isMatch(s, p);
		Assert.assertEquals(false,match);
	}
}