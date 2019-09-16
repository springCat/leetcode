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
public class Solution2 {


	/**
	 *
	 * 1
	 *   p\s a a
	 *   a   1 1
	 *         0
	 * 2
	 *   p\s a a 0
	 *   a   1 1 0
	 *   *   1 1 0
	 *   0   0 0 0
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
	Boolean[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
    	//看执行结果，可以提高性能，预处理过就不再处理，为什么一定要设置为true？
        if (memo[i][j] != null) {
            return memo[i][j] == true;
        }
        boolean ans;
        //判断是否到终点了
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
        	//当前字符串是否匹配
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));
			//遇到下一个字符是*号且没有跨届时
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
            	//*为空时，消除掉前面掉字符，多new1个长度就是简化这边多罗技处理
                ans = (dp(i, j+2, text, pattern) ||
						//匹配到时，看看你能不能匹配text后面到字符串，一起消除掉
                       first_match && dp(i+1, j, text, pattern));
            } else {
            	//正常匹配
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans;
        return ans;
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
}