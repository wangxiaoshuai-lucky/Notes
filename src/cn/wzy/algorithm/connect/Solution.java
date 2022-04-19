package cn.wzy.algorithm.connect;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        while (head != null) {
            Node cur = head, nextHead = null, nextTail = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) {
                        nextTail = nextHead = cur.left;
                    } else {
                        nextTail.next = cur.left;
                        nextTail = nextTail.next;
                    }
                }
                if (cur.right != null) {
                    if (nextHead == null) {
                        nextTail = nextHead = cur.right;
                    } else {
                        nextTail.next = cur.right;
                        nextTail = nextTail.next;
                    }
                }
                cur = cur.next;
            }
            head = nextHead;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3), null);
        Node n = new Solution().connect(root);
        System.out.println(n);
    }
}