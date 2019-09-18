package org.springcat.leetcode.utils;

public class Utils {

	public final static Utils me = new Utils();

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

	public ListNode init(int[] numbers){
		ListNode temp = new ListNode(-1);
		ListNode head = temp;
		for (int i = 0; i < numbers.length; i++) {
			temp.next = new ListNode(numbers[i]);
			temp = temp.next;
		}
		return head.next;
	}

	public void printLinklist(ListNode listNode){
		while (listNode != null){
			System.out.print(listNode.val+",");
			listNode = listNode.next;
		}
		System.out.println();
	}
}
