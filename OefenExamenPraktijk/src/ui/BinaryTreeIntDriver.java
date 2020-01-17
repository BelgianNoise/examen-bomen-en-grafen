package ui;

import domain.*;

public class BinaryTreeIntDriver {
	public static void main(String[] args) {
		// niveau 4
		BinaryTreeInt vijf = new BinaryTreeInt(5);
		BinaryTreeInt zeven = new BinaryTreeInt(7);
		BinaryTreeInt min_een = new BinaryTreeInt(-1);
		BinaryTreeInt vijftig = new BinaryTreeInt(50);

		// niveau 3
		BinaryTreeInt twee = new BinaryTreeInt(2, vijf, null);
		BinaryTreeInt vijftien = new BinaryTreeInt(15, zeven, min_een);
		BinaryTreeInt twintig = new BinaryTreeInt(20, vijftig, null);

		// niveau 2
		BinaryTreeInt min_tien = new BinaryTreeInt(-10, twee, vijftien);
		BinaryTreeInt zeven2 = new BinaryTreeInt(7, null, twintig);

		// niveau 1
		BinaryTreeInt drie = new BinaryTreeInt(3, min_tien, zeven2);
		
		System.out.println("De som is:" + drie.kinderSom());
	}
}
