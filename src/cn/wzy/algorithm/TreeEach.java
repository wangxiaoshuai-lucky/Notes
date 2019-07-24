package cn.wzy.algorithm;

import java.util.Stack;

/**
 * @ClassName TreeEach
 * @Author WangZY
 * @Date 2019/7/23 11:04
 * @Version 1.0
 **/
public class TreeEach {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static void print(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.val + ", ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop().right;
            } else {
                break;
            }
        }
    }

    static void first(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + ", ");
        first(root.left);
        first(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(13);
        root.right = new Node(14);
        root.left.left = new Node(15);
        root.left.right = new Node(16);
        root.right.left = new Node(17);
        root.right.right = new Node(18);
        print(root);
        System.out.println();
        first(root);
    }
}
