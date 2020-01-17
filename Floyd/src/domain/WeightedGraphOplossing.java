package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphOplossing {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public WeightedGraphOplossing(double[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}

	public int[][] findDistances() {
		int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		double[][] distanceMatrix = this.gewichtenMatrix.clone();
		for (int knoop = 0; knoop < path.length; knoop++) {
			for (int j = 0; j < path.length; j++) {
				for (int k = 0; k < path.length; k++) {
					if (distanceMatrix[j][k] > distanceMatrix[j][knoop] + distanceMatrix[knoop][k]) {
						distanceMatrix[j][k] = distanceMatrix[j][knoop] + distanceMatrix[knoop][k];
						path[j][k] = knoop+1;
					}
				}
			}
		}
		return path;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path) {
		List<Integer> res = new ArrayList<>();
		if (i == j)
			return res;
		
		int tussen = path[i-1][j-1];
		if (tussen == 0) {
			if (this.gewichtenMatrix[i-1][j-1] != infty) { 
				res.add(i);
				res.add(j);    
			}
			return res;
		} else {
			// tussenliggers links van "tussen" controleren
			res.addAll(this.getShortestPath(i, tussen, path));
			
			// tussenliggers rechts van "tussen" controleren
			List<Integer> rest = this.getShortestPath(tussen, j, path);
			rest.remove(0); // duplicatie van knopen vermijden
			res.addAll(rest);
			
			return res;
		}
	}
	
	public int berekenLengte(List<Integer> pad){
		int som = 0;
		for (int i = 0 ; i < pad.size() - 1 ; i++)
			som+= this.gewichtenMatrix[pad.get(i)-1][pad.get(i+1) - 1];
		return som;
	}
	

}
