package cn.wzy.bishi.bytedance.time2;

/**
 * @ClassName NumbersToTree 将有序数组转成最矮的二叉搜索树bst
 * @Author WangZY
 * @Date 2019/7/22 16:24
 * @Version 1.0
 **/
public class NumbersToTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Node generator(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        Node left = generator(nums, start, middle - 1);
        Node right = generator(nums, middle + 1, end);
        return new Node(nums[middle], left, right);
    }

    static void print(Node node) {
        if (node == null)
            return;
        print(node.left);
        System.out.print(node.val + ",");
        print(node.right);
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node node = generator(numbers, 0, numbers.length - 1);
        print(node);
    }
}
