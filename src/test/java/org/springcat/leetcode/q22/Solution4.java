package org.springcat.leetcode.q22;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Solution4 {
    public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		buildString(result,"",n,0,0);
		return result;
	}
	private void buildString(List<String> result,String currentStr,int n,int left,int right){
    	//完成生成
    	if(currentStr.length() == 2*n ){
    		result.add(currentStr);
			return;
		}
		if (left < n)
			buildString(result, currentStr+"(", n,left+1, right);
		if (left > right)
			buildString(result, currentStr+")", n,left, right+1);
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
		String[] actual = new String[strings.size()];
		strings.toArray(actual);
		Arrays.sort(actual);
		Arrays.sort(except);
		Assert.assertArrayEquals(except,actual);
	}

}