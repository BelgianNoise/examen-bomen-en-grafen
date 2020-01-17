package domain;

import java.util.ArrayList;

public class Graph {

	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;
	
	public Graph(double[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}
	
	public double berekenKleinsteDebiet(ArrayList<Integer> pad) {
		if(pad.size() < 2) {
			throw new IllegalArgumentException();
		}
		
		Double min = Double.POSITIVE_INFINITY;
		for(int i = 0; i<pad.size()-1;i++) {
			if(gewichtenMatrix[pad.get(i)-1][pad.get(i+1)-1] < min) {
				min = gewichtenMatrix[pad.get(i)-1][pad.get(i+1)-1];
			}
		}
		if(min == Double.POSITIVE_INFINITY) {
			throw new IllegalArgumentException();
		}
		return min;
	}
}
