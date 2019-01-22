package cn.wzy.algorithm;

import java.util.Stack;

public class BTreeTraversal {
	static class BTree {
		BTree left;
		BTree right;
		int id;
		BTree(BTree l, BTree r, int id) {
			this.id = id;
			this.left = l;
			this.right = r;
		}
	}

	public static void main(String[] args) {
		BTree head = new BTree(null, null, 0);
		head.left = new BTree(new BTree(null,null,1), new BTree(null,null,2),3);
		head.right = new BTree(new BTree(null,null,4), new BTree(null,null,5),6);
		Stack<BTree> stack = new Stack<>();
		BTree now = head;
		while (now != null || !stack.empty()){
			//一致向左查找
			while (now != null) {
				stack.push(now);
				now = now.left;
			}
			//左边到底之后，回退输出当前节点，又开始处理右节点
			if (!stack.isEmpty()) {
				BTree tmp = stack.pop();
				System.out.println(tmp.id);
				now = tmp.right;
			}
		}
	}
}
