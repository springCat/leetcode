package org.springcat.leetcode.q24;

import org.junit.Assert;
import org.junit.Test;
import org.springcat.leetcode.utils.ListNode;
import org.springcat.leetcode.utils.Utils;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode swapPairs(ListNode list) {
    	ListNode head = new ListNode(-1);
		head.next = list;
        ListNode index = head;
        while (index.next != null &&index.next.next != null){
        	ListNode temp = index.next;
			index.next = index.next.next;
			temp.next = temp.next.next;
			index.next.next = temp;
			index = index.next.next;
		}
		return head.next;
    }

    @Test
    public void test1(){
    	int[] i1 = {1,2,3,4};
		ListNode init = Utils.me.init(i1);

		ListNode result = swapPairs(init);
		int[] i = {2,1,4,3};
		ListNode except = Utils.me.init(i);

		Assert.assertTrue(Utils.me.isEqual(except,result));
	}

	@Test
	public void test2(){
		int[] i1 = {1};
		ListNode init = Utils.me.init(i1);
		ListNode result = swapPairs(init);
		int[] i = {1};
		ListNode except = Utils.me.init(i);
		Assert.assertTrue(Utils.me.isEqual(except,result));
	}

	@Test
	public void test3(){
		int[] i1 = {1,2,3};
		ListNode init = Utils.me.init(i1);
		ListNode result = swapPairs(init);
		int[] i = {2,1,3};
		ListNode except = Utils.me.init(i);
		Assert.assertTrue(Utils.me.isEqual(except,result));
	}
}