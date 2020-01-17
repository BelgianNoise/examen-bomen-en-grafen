package domain;

import java.awt.List;
import java.util.ArrayList;

public class Graph {

	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public Graph(double[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}
	
	public ArrayList<Integer> berekenWegMetOptimaalDebiet(int van, int naar){
		ArrayList<ArrayList<Integer>> paden = this.alleMogelijkePaden(van, naar);
		ArrayList<Double> minDebiet = new ArrayList<>();
		
		for(ArrayList<Integer> pad : paden) {
			minDebiet.add(this.berekenKleinsteDebiet(pad));
		}
		int maxindex = 0;
		Double max = 0.0;
		for(int i =0; i<minDebiet.size();i++) {
			if(minDebiet.get(i) > max) {
				max = minDebiet.get(i);
				maxindex = i;
			}
		}
		return paden.get(maxindex);
	}
	
	public double berekenKleinsteDebiet(ArrayList<Integer> pad) {
		if (pad.size() < 2) {
			throw new IllegalArgumentException();
		}

		Double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < pad.size() - 1; i++) {
			if (gewichtenMatrix[pad.get(i) - 1][pad.get(i + 1) - 1] < min) {
				min = gewichtenMatrix[pad.get(i) - 1][pad.get(i + 1) - 1];
			}
		}
		if (min == Double.POSITIVE_INFINITY) {
			throw new IllegalArgumentException();
		}
		return min;
	}

	public ArrayList<ArrayList<Integer>> alleMogelijkePaden(int van, int naar) {
		ArrayList<ArrayList<Integer>> v = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < this.gewichtenMatrix.length; i++) {
			if (this.gewichtenMatrix[van - 1][i] != 0 && this.gewichtenMatrix[van - 1][i] != infty) {
				if (i == naar - 1) {
					ArrayList<Integer> res = new ArrayList<>();
					res.add(van);
					res.add(naar);
					v.add(res);
				} else {
					ArrayList<ArrayList<Integer>> m = this.alleMogelijkePaden(i + 1, naar);
					if (m.size() != 0) {
						for (ArrayList<Integer> l : m) {
							l.add(0, van);
							v.add(l);
						}
					}
				}
			}
		}
		return v;
	}
}
