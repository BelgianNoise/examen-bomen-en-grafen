package domain;

import java.util.ArrayList;

public class BinaryTreeInt {
	private int data;
	private BinaryTreeInt leftTree, rightTree;

	public BinaryTreeInt(int data) {
		this(data, null, null);
	}

	public BinaryTreeInt(int data, BinaryTreeInt leftTree, BinaryTreeInt rightTree) {
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	public void printPreorder() {
		System.out.print(this.data + " ");
		if (this.leftTree != null)
			this.leftTree.printPreorder();
		if (this.rightTree != null)
			this.rightTree.printPreorder();
	}

	public void printInOrder() {
		if (this.leftTree != null)
			this.leftTree.printInOrder();
		System.out.print(this.data + " ");
		if (this.rightTree != null)
			this.rightTree.printInOrder();
	}

	public void printPostOrder() {
		if (this.leftTree != null)
			this.leftTree.printPostOrder();
		if (this.rightTree != null)
			this.rightTree.printPostOrder();
		System.out.print(this.data + " ");
	}

	public int countNodes() {
		if (leftTree == null) {
			if (rightTree == null) {
				return 1;
			} else {
				return 1 + rightTree.countNodes();
			}
		} else {
			if (rightTree == null) {
				return 1 + leftTree.countNodes();
			} else {
				return 1 + leftTree.countNodes() + rightTree.countNodes();
			}
		}
		/******************
		 * Simple version
		 *****************/
		/*
		 * return 1 + (this.leftTree == null ? 0 : this.leftTree.countNodes()) +
		 * (this.rightTree == null ? 0 : this.rightTree.countNodes());
		 */
	}

	public int getDepth() {
		return 1 + Math.max((leftTree == null ? 0 : leftTree.getDepth()),
				(rightTree == null ? 0 : rightTree.getDepth()));
	}

	public boolean isLeaf() {
		return leftTree == null && rightTree == null;
	}

	public int countLeaves() {
		if (this.isLeaf()) {
			return 1;
		} else {
			return (this.leftTree == null ? 0 : this.leftTree.countLeaves())
					+ (this.rightTree == null ? 0 : this.rightTree.countLeaves());
		}

	}

	public ArrayList<Integer> getDataLeaves() {
		ArrayList<Integer> res = new ArrayList<>();
		if (this.isLeaf()) {
			res.add(this.data);
		} else {
			res = (this.leftTree == null ? new ArrayList<>() : this.leftTree.getDataLeaves());
			ArrayList<Integer> rightLeaves = (this.rightTree == null ? new ArrayList<>()
					: this.rightTree.getDataLeaves());
			res.addAll(rightLeaves);
		}
		return res;
	}

	public boolean contains(int s) {

		if (s == data) {
			return true;
		} else {
			return leftTree != null && leftTree.contains(s) ? true : rightTree != null && rightTree.contains(s);
		}
	}
	
	public int kinderSom() {
		int res = 0;
		if(data % 5 == 0) {
			if(leftTree != null) res += leftTree.data;
			if(rightTree != null) res += rightTree.data;
		}
		if(leftTree != null) {
			res += leftTree.kinderSom();
		}
		if(rightTree != null) {
			res += rightTree.kinderSom();
		}
		return res;
	}
}
