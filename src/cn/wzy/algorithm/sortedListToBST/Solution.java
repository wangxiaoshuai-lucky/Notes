package cn.wzy.algorithm.sortedListToBST;


class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = splitMid(head);
        TreeNode rst = new TreeNode(mid.val, null, sortedListToBST(mid.next));
        if (mid != head) {
            rst.left = sortedListToBST(head);
        }
        return rst;
    }

    public ListNode splitMid(ListNode head) {
        ListNode fast = head, slow = head, preEnd = null;
        while (fast.next != null && fast.next.next != null) {
            preEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (preEnd != null) {
            preEnd.next = null;
        }
        return slow;
    }
}