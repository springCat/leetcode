package org.springcat.leetcode.q30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
    	if(words == null || words.length == 0 || words[0].length() == 0){
    		return result;
		}
    	Arrays.sort(words);
		int eachLen = words[0].length();
		int wholeLen = eachLen * words.length;
		for (int i = 0; i <= s.length()-wholeLen; i++) {
			String substring = s.substring(i, i+wholeLen);
			String[] split = split(substring,eachLen);
			Arrays.sort(split);
			if(Arrays.equals(words, split)){
				result.add(i);
			}
		}
		return result;
    }

    private String[] split(String s,int n){
		int len = s.length() / n;
		String[] result = new String[len];
		for (int i = 0; i < len; i++) {
			result[i] = s.substring(i*n,(i+1)*n);
		}
		return result;
	}

    @Test
    public void test1(){
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		System.out.println(findSubstring(s,words));
    }

	@Test
	public void test2(){
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","word"};
		System.out.println(findSubstring(s,words));
	}


	@Test
	public void test3(){
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"",""};
		System.out.println(findSubstring(s,words));
	}
}