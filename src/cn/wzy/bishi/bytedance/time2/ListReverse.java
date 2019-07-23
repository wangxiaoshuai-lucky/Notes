package cn.wzy.bishi.bytedance.time2;

import java.util.Stack;

/**
 * @ClassName ListReverse
 * @Author WangZY
 * @Date 2019/7/22 16:42
 * @Version 1.0
 **/
public class ListReverse {

    static class Node{
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    static void change(Node node, int k) {
        Node head = node;
        for (int t = 0; ;t++) {
            if (t % 2 == 0) {
                for (int i = 0; i < k; i++) {
                    head = node;
                    if (node == null)
                        return;
                    node = node.next;
                }
            } else {
                Node[] nodes = reverse(node, k);
                head.next = nodes[0];
                head = nodes[1];
                node = head.next;
            }
        }
    }

    private static Node[] reverse(Node node, int k) {
        if (node == null || node.next == null) {
            return new Node[]{node, null};
        }
        Node head = new Node(-1);
        Node tail = null;
        Node next = node;
        for (int i = 0; i < k; i++) {
            node = next;
            if (node == null) {
                return new Node[]{head.next, tail};
            }
            next = node.next;
            node.next = head.next;
            head.next = node;
            if (tail == null) {
                tail = head.next;
            }
        }
        if (tail != null) {
            tail.next = next;
        }
        return new Node[]{head.next, tail};
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        change(head.next, 3);
        System.out.println(head);
    }
}
