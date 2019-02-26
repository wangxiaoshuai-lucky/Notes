package cn.wzy.algorithm;

import java.util.List;

public class ListNodeSort {
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(4);
		head.next.next.next= new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(8);
		head = sort(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}


	static ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = head, last = head;
		while (last.next != null) {
			last = last.next;
			if (last.next != null) {
				last = last.next;
			} else {
				break;
			}
			middle = middle.next;
		}
		ListNode next = middle.next;
		middle.next = null;
		sort(head);
		sort(next);
		return merge(head, next);
	}

	static ListNode merge(ListNode node1, ListNode node2) {
		ListNode head = node1;
		node1 = node1.next;
		ListNode s = head;
		while (true) {
			if (node1 == null && node2 == null) {
				break;
			} else if (node1 == null) {
				s.next = node2;
				node2 = node2.next;
				s = s.next;
			} else if (node2 == null) {
				s.next = node1;
				node1 = node1.next;
				s = s.next;
			} else {
				if (node1.val < node2.val) {
					s.next = node1;
					node1 = node1.next;
					s = s.next;
				} else {
					s.next = node2;
					node2 = node2.next;
					s = s.next;
				}
			}
		}
		return head;
	}
}
