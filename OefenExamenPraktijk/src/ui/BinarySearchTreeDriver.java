package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>();
		boom.addNode(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		boom.addNode(10);
		boom.addNode(11);
		System.out.println(" Volledige Boom Inorder ");
		boom.printInOrder();
		System.out.println(" \nBoom zonder 8 ");
		boom.deelZonder(8).printInOrder();
		System.out.println(" \nBoom zonder 4 ");
		boom.deelZonder(4).printInOrder();
	}

}