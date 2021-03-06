package org.springcat.leetcode.q22;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))", 1 1 1 -1 -1 -1
 *   "(()())", 1 1 -1 1 -1 -1
 *   "(())()", 1 1 -1 -1 1 -1
 *   "()(())", 1 -1 1 1 -1 -1
 *   "()()()"  1 -1 1 -1 1 -1
 * ]
 *
 * 例如，给出 n = 2，生成结果为：
 *
 * [
 *   "(())",1 -1
 *   "()()",1 -1 1 -1
 * ]
 *
 * 例如，给出 n = 1，生成结果为：
 *
 * [
 *   "()", 10
 * ]
 */
public class Solution2 {
    public List<String> generateParenthesis(int n) {
		if(n == 0) {
			return Arrays.asList();
		}
		Set<String> result = new HashSet<>();
		result.add("()");
		for (int i = 1; i < n; i++) {
			result = merge(result);
		}
		return new ArrayList<String>(result);
	}

	private Set<String> merge(Set<String> temp){
		HashSet<String> result = new HashSet<>();
		for (String s : temp) {
			for (int i = 0; i < s.length(); i++) {
				StringBuilder stringBuilder = new StringBuilder(s);
				stringBuilder.insert(i,"()");
				result.add(stringBuilder.toString());
			}
		}
		return result;
	}


	@Test
	public void test1(){
		List<String> strings = generateParenthesis(3);
		String[] except = {
				"((()))",
				"(()())",
				"(())()",
				"()(())",
				"()()()"
		};
		Assert.assertArrayEquals(except,strings.toArray());
	}

}