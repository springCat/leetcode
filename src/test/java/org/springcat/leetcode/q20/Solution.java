package org.springcat.leetcode.q20;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isValid(String s) {
		Map<Character,Character> map =new HashMap(){{
			put( '(',')');
			put( '[',']');
			put( '{','}');
		}};
		Stack<Character> characters = new Stack<>();
		for (char c : s.toCharArray()) {
			if(c == '(' || c == '{' || c == '['){
				characters.push(c);
			}else if(c == ')' || c == '}' || c == ']'){
				if(characters.empty()){
					return false;
				}
				Character pop = characters.pop();
				if(map.get(pop) != c){
					return false;
				}
			}
		}
		return characters.empty();
	}

	@Test
	public void test1(){
    	String s = "()";
		Assert.assertEquals(true,isValid(s));
	}

	@Test
	public void test2(){
    	String s = "[";
		Assert.assertEquals(false,isValid(s));
	}
}