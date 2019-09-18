package org.springcat.leetcode.q23;

import org.junit.Assert;
import org.junit.Test;
import org.springcat.leetcode.utils.ListNode;
import org.springcat.leetcode.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists==null || lists.length == 0) return null;
		ListNode head = new ListNode(-1);
		ListNode tempIndex = head;
		head.next = lists[0];
		List<Integer> list = new ArrayList<>();

		for (ListNode node : lists) {
			tempIndex.next = node;
			while (tempIndex.next != null){
				list.add(tempIndex.next.val);
				tempIndex = tempIndex.next;
			}
		}
		Collections.sort(list);
		ListNode resultIndex = head;
		for (int i = 0; i < list.size(); i++) {
			resultIndex.next.val = list.get(i);
			resultIndex = resultIndex.next;
		}
		return head.next;
	}

	@Test
	public void test1(){
    	int[] i1= {1,4,5};
		ListNode node1 = Utils.me.init(i1);
		int[] i2= {1,3,4};
		ListNode node2 = Utils.me.init(i2);
		int[] i3= {2,6};
		ListNode node3 = Utils.me.init(i3);
		ListNode[] node = {node1,node2,node3};

		ListNode listNode = mergeKLists(node);

		int[] i = {1,1,2,3,4,4,5,6};
		ListNode except = Utils.me.init(i);

		Assert.assertTrue(Utils.me.isEqual(except,listNode));
	}
}