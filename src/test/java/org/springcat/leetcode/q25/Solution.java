package org.springcat.leetcode.q25;

import org.junit.Assert;
import org.junit.Test;
import org.springcat.leetcode.utils.ListNode;
import org.springcat.leetcode.utils.Utils;

/**
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public ListNode reverseKGroup(ListNode node,int k){
    	ListNode head = null;
    	ListNode tail = null;
		ListNode tempIndex = node;
		int n = k;
		while (n > 0 && tempIndex !=null){
			ListNode temp = tempIndex;
			tempIndex = tempIndex.next;
			if(head == null){
				tail = temp;
			}
			temp.next = head;
			head = temp;
			n--;
		}
		if( tempIndex != null && n == 0) {
			tail.next = reverseKGroup(tempIndex, k);
		}

		if(tempIndex == null && n != 0) {
			head = reverseKGroup(head, k - n);
		}
		return head;
	}

	@Test
	public void test1(){
		int[] i1 = {1,2,3,4};
		ListNode init = Utils.me.init(i1);

		ListNode result = reverseKGroup(init,2);
		int[] i = {2,1,4,3};
		ListNode except = Utils.me.init(i);

		Assert.assertTrue(Utils.me.isEqual(except,result));
	}

	@Test
	public void test2(){
		int[] i1 = {1,2,3,4,5,6,7,8,9,10,11};
		ListNode init = Utils.me.init(i1);
		ListNode reverse = reverse(init,3);
		Utils.me.printLinklist(reverse);
	}
}