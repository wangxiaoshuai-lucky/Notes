package cn.wzy.Collection;

public class LinkedList<E> {

	static class Node<E>{
		E val;
		Node<E> next;
		Node(E val, Node<E> next) {
			this.val = val;
			this.next = next;
		}
	}

	Node<E> head;

	public void add(E val){
		if (!(val instanceof Comparable)) {
				return;
		}
		if (head == null) {
			head = new Node<>(val, null);
			return;
		}
		if ( ((Comparable) head.val).compareTo(val) >= 0) {
			head = new Node<>(val,head);
			return;
		}
		Node<E> pre = head;
		Node<E> p = head.next;
		while (p != null && ((Comparable) p.val).compareTo(val) < 0) {
			pre = pre.next;
			p = p.next;
		}
		Node<E> node = new Node<>(val,p);
		pre.next = node;
	}

	public void remove(E val){
		if (head == null)
			return;
		if (head.val.equals(val)){
			while (head != null && head.val.equals(val)){
				head = head.next;
			}
			return;
		}
		Node<E> pre = head;
		Node<E> p = head.next;
		while (p != null && ((Comparable) p.val).compareTo(val) <= 0) {
			if (((Comparable) p.val).compareTo(val) < 0) {
				pre = pre.next;
			}
			p = p.next;
		}
		pre.next = p;
	}

	public void print(){
		Node<E> p = head;
		while (p != null){
			System.out.println(p.val);
			p = p.next;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(12);
		list.add(12);
		list.add(12);
		list.print();
		list.remove(12);
		System.out.println("=========");
		list.print();
	}
}
