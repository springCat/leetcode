package org.springcat.leetcode.q21;

import org.junit.Assert;
import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode index = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				index.next = l1;
				l1 = l1.next;
			} else {
				index.next = l2;
				l2 = l2.next;
			}
			index = index.next;
		}

		index.next = l1 == null ? l2 : l1;
		return  head.next;
	}

	@Test
	public void test1(){
		int[] i1 = {1,2,4};
		ListNode l1 = init(i1);
		int[] i2 = {1,3,4};
		ListNode l2 = init(i2);

		int[] i3 = {1,1,2,3,4,4};
		ListNode l3 = init(i3);
		ListNode listNode = mergeTwoLists(l1, l2);
		Assert.assertTrue(isEqual(l3,listNode));
	}

	public boolean isEqual(ListNode l1,ListNode l2){
		try {
			while (l1 != null){
				if(l1.val != l2.val){
					return false;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
		}catch (Exception e){
			return false;
		}
		return true;
	}

	private ListNode init(int[] numbers){
		ListNode temp = new ListNode(-1);
		ListNode head = temp;
		for (int i = 0; i < numbers.length; i++) {
			temp.next = new ListNode(numbers[i]);
			temp = temp.next;
		}
		return head.next;
	}

	private void printLinklist(ListNode listNode){
		while (listNode != null){
			System.out.print(listNode.val+",");
			listNode = listNode.next;
		}
		System.out.println();
	}
}