package org.springcat.leetcode.q19;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

    public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode sentry = new ListNode(-1);
		sentry.next =head;
		//要删除节点的前一个节点
		ListNode left = sentry;
		//尾节点
		ListNode right = sentry;
		//因为是要删除节点的前一个节点，所以n+1
		for (int i = n+1; i > 0; i--) {
			right = right.next;
		}
		while (right != null){
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;
		return sentry.next;
    }

    @Test
    public void test1(){
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);

		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		ListNode listNode = removeNthFromEnd(listNode1, 2);
		printLinklist(listNode);
	}

	@Test
	public void test2(){
		ListNode listNode1 = new ListNode(1);
		ListNode listNode = removeNthFromEnd(listNode1, 1);
		printLinklist(listNode);
	}


	@Test
	public void test3(){
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		listNode1.next = listNode2;

		ListNode listNode = removeNthFromEnd(listNode1, 2);
		printLinklist(listNode);
	}

	private void printLinklist(ListNode listNode){
		while (listNode != null){
			System.out.print(listNode.val+",");
			listNode = listNode.next;
		}
		System.out.println();
	}
}