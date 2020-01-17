package ui;
import java.util.ArrayList;

import domain.*;

public class GraphDriver {
	public static void main(String[] args) {
		
		double infty = Double.POSITIVE_INFINITY;
		
		double[][] matrix = {{0,15,8,infty,infty},
				{infty,0,7,20,5},
				{infty,infty,0,4,infty},
				{infty,infty,infty,0,infty},
				{infty,infty,infty,infty,0}};
		Graph g = new Graph(matrix);
		ArrayList<Integer> pad = new ArrayList<>();
		pad.add(1);
		pad.add(2);
		pad.add(3);
		pad.add(4);
		
		System.out.println(g.berekenKleinsteDebiet(pad));
		System.out.println(g.berekenWegMetOptimaalDebiet(1, 4));
		
	}
}
