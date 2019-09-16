package org.springcat.leetcode.q2;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryBit = 0;
		ListNode result = new ListNode(0);
		ListNode current = result;
		while (l1 != null && l2 != null){
			current.next =  new ListNode(l1.val+l2.val+carryBit);
			if(current.next.val>=10){
				current.next.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			current = current.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null){
			current.next = new ListNode(l1.val+ carryBit);
			if(current.next.val>=10){
				current.next.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			current = current.next;
			l1 = l1.next;
		}
		while (l2 != null){
			current.next = new ListNode(l2.val+ carryBit);
			if(current.next.val>=10){
				current.next.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			current = current.next;
			l2 = l2.next;
		}
		if(carryBit > 0){
			current.next =  new ListNode(carryBit);
		}
		return result.next;
    }

    @Test
    public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(8);
		l1.next = l1;

		ListNode l2 = new ListNode(0);

		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode);
	}

	@Test
	public void test2(){
		ListNode l1 = new ListNode(5);

		ListNode l2 = new ListNode(5);

		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode);
	}
}