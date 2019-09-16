package org.springcat.leetcode.q17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
		Map<Character, String> phone = new HashMap<Character, String>() {{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
		char[] digitChars = digits.toCharArray();
		List<String> result = new ArrayList<String>();
		result.add("");
		for (char digitChar : digitChars) {
			String s = phone.get(digitChar);
			if(s != null) {
				result = join(result,s);
			}
		}

		if(result.size() == 1){
			return new ArrayList<String>();
		}

		return result;
	}
	private List<String> join(List<String> list,String s){
    	List<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < s.length(); j++) {
				String news = list.get(i)+s.charAt(j);
				result.add(news);
			}
		}
		return result;
	}

	@Test
	public void test1(){
		String s = "23";
		List<String> strings = letterCombinations(s);
		System.out.println(strings);
	}

	@Test
	public void test2(){
		String s = "";
		List<String> strings = letterCombinations(s);
		System.out.println(strings);
	}

}