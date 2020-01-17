package ui;
import domain.*;

import domain.BinaryTree;

public class BinaryTreeDriver {
	public static void main(String[] args) {
		// niveau 4
		BinaryTree<Integer> zes = new BinaryTree<>(6);

		// niveau 3
		BinaryTree<Integer> negen = new BinaryTree<>(9);
		BinaryTree<Integer> zeven = new BinaryTree<>(7);
		BinaryTree<Integer> drie = new BinaryTree<>(3);
		BinaryTree<Integer> twee = new BinaryTree<>(2, zes, null);
		
		//niveau 2
		BinaryTree<Integer> min_vier = new BinaryTree<>(-4, negen, zeven);
		BinaryTree<Integer> min_zeven = new BinaryTree<>(-7, drie, twee);
		
		// niveau 1
		BinaryTree<Integer> vijf = new BinaryTree<>(5, min_vier, min_zeven);
		
		
		System.out.println("volledige binaire boom strikt? -> " + vijf.isStrikt());
		System.out.println("binaire boom met enkel node 9 strikt? -> " + negen.isStrikt());
		System.out.println("binaire boom met node -4 en kinderen 9 en 7 strikt? -> " + min_vier.isStrikt());
	}
}
