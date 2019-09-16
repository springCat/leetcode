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
public class Solution {
    public List<String> generateParenthesis(int n) {
    	if(n == 0) {
    		return Arrays.asList();
		}
		List<String> result = new ArrayList<String>();
		buildString(result,n,"",0);
		return result;
	}
	private void buildString(List<String> result,int n,String currentStr,int score){
    	//完成生成
    	if(currentStr.length() == 2*n && score ==0){
    		result.add(currentStr);
			return;
		}
    	//失败的字符串
		if(score < 0 || score > n){
			return;
		}
		//优化效率，当剩余位数全是)时，score也大于0
		if( 2*n - currentStr.length() < score){
			return;
		}
		buildString(result,n,currentStr+"(",score+1);
		buildString(result,n,currentStr+")",score-1);
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