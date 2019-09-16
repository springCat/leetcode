package org.springcat.leetcode.q3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int max = 0;
		int i = 0;
		int j = 0;
		while (i<n &&j <n){
			if(set.contains(s.charAt(j))){
				set.remove(s.charAt(i));
				i++;
			}else {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max,set.size());
			}
		}
		return max;
    }

    @Test
    public void test1(){
    	String s ="abcabcbb";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}

    @Test
    public void test2(){
    	String s =" ";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}

    @Test
    public void test3(){
    	String s = "jbpnbwwd";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}
}