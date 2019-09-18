package org.springcat.leetcode.q22;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
            	for (String left: generateParenthesis(c))
            		for (String right: generateParenthesis(n-1-c))
            			ans.add("(" + left + ")" + right);
        }
        return ans;
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