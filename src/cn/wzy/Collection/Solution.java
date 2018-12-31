package cn.wzy.Collection;

public class Solution {
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode s = null;
		int c = 0;
		while (l1 != null|| l2 != null || c != 0) {
			int tmp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + c;
			c = tmp / 10;
			if (head == null) {
				head = new ListNode(tmp % 10);
				s = head;
			} else {
				ListNode next = new ListNode(tmp % 10);
				s.next = next;
				s = next;
			}
			if (l1 != null && l1.next != null) {
				l1 = l1.next;
			} else {
				l1 = null;
			}
			if (l2 != null && l2.next != null) {
				l2 = l2.next;
			} else {
				l2 = null;
			}
		}
		return head;
	}
}
