package cn.wzy.algorithm;

import java.util.Arrays;

public class reConstructBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int now = pre[0];
		TreeNode node = new TreeNode(now);
		int index = 0;
		for (int i = 0; i < in.length; i++) {
			if (now == in[i]) {
				index = i;
				break;
			}
		}
		if (index != 0) {
			int[] newPre = Arrays.copyOfRange(pre, 1, index + 1);
			int[] newIn = Arrays.copyOfRange(in, 0, index);
			node.left = reConstructBinaryTree(newPre, newIn);
		}
		if (index != in.length - 1) {
			int[] newPre = Arrays.copyOfRange(pre, index + 1, pre.length);
			int[] newIn = Arrays.copyOfRange(in, index + 1, in.length);
			node.right = reConstructBinaryTree(newPre, newIn);
		}
		return node;
	}
}
