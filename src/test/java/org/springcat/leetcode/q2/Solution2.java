package org.springcat.leetcode.q2;

import org.junit.Test;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryBit = 0;
		ListNode head = new ListNode(-1);
		head.next = l1;
		ListNode pre = head;

		while (l1 != null && l2 != null){
			l1.val += l2.val+carryBit;
			if(l1.val >= 10){
				l1.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			pre = l1;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null){
			l1.val += carryBit;
			if(l1.val >= 10){
				l1.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			pre =l1;
			l1 = l1.next;
		}

		if(l2 == null){
			if(carryBit > 0){
				pre.next =  new ListNode(carryBit);
			}
			return head.next;
		}

		pre.next = l2;
		while (l2 != null){
			l2.val += carryBit;
			if(l2.val >= 10){
				l2.val -= 10;
				carryBit = 1;
			}else {
				carryBit = 0;
			}
			pre =l2;
			l2 = l2.next;
		}

		if(carryBit > 0){
			pre.next =  new ListNode(carryBit);
		}
		return head.next;
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

	@Test
	public void test3(){
		ListNode l1 = new ListNode(1);

		ListNode l2 = new ListNode(9);
		ListNode l21 = new ListNode(9);
		l2.next = l21;

		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode);
	}

	@Test
	public void test4(){
		ListNode l1 = new ListNode(9);
		ListNode l11 = new ListNode(9);
		l1.next = l11;

		ListNode l2 = new ListNode(9);

		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode);
	}
}