package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphOplossing {
	private final boolean[][] nabijheidsMatrix;
	public static final int infty = Integer.MAX_VALUE;

	public GraphOplossing(int[][] matrix) {
		if (!isGeldigeNabijheidsMatrix(matrix))
			throw new IllegalArgumentException("No valid nabijheidsmatrix");

		this.nabijheidsMatrix = new boolean[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				this.nabijheidsMatrix[i][j] = matrix[i][j] == 1;
	}

	/*
	 * een nabijheidsmatrix is correct indien het aantal rijen gelijk is aan het
	 * aantal kolommen en de diagonaal van linksboven naar rechtsonder overal
	 * nul is en alle elementen gelijk zijn aan 0 of 1
	 */
	private boolean isGeldigeNabijheidsMatrix(int[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			return false;

		for (int i = 0; i < matrix.length; i++)
			if (matrix[i][i] != 0)
				return false;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				if (matrix[i][j] != 0 && matrix[i][j] != 1)
					return false;
		return true;
	}

	private int getAantalKnopen() {
		return this.nabijheidsMatrix.length;
	}

	private int[] findAncestors(int start, int destination) {// nummering van start-knoop (1..aantal_knopen) naar eindKnoop (destination)
		int[] ancestors = new int[this.getAantalKnopen()];
		initArray(ancestors, infty);

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		ancestors[start-1] = 0;
		boolean stop= false;
		while (!queue.isEmpty() &&!stop) {
			int node = queue.remove();
			for (int i = 0; i < this.getAantalKnopen() && !stop; i++) {
				if (this.nabijheidsMatrix[node-1][i] && ancestors[i] == infty) {
					queue.add(i+1);
					ancestors[i] = node;
					if (i + 1 == destination) stop = true;
				}
			}
		}
		return ancestors;
	}

	public List<Integer> findPath(int start , int destination) {
		if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
			throw new IllegalArgumentException();
		
		int[] ancestors = this.findAncestors(start, destination);
		List<Integer> path = new LinkedList<>();
		if (ancestors[destination-1] == infty)
			return path;
		else {
			int i = destination - 1; //info van knoop met nummer destination staat in ancestor-rij op plaats destination - 1
			while (i >= 0 && i < ancestors.length) {
				path.add(0, i+1);
				i = ancestors[i] - 1; 
			}
			return path;
		}

	}

	private void initArray(int[] array, int value) {
		for (int i = 0; i < array.length; i++)
			array[i] = value;
	}

	// methode om tussenliggend resultaat te kunnen schrijven naar het scherm
	public String geefAncestors(int start, int destination) {
		String res = "Ancestors van "+start+" naar "+destination+":\n";
		int[] ancestors = this.findAncestors(start, destination);
		for (int a=0; a<ancestors.length; a++) 
			res += ancestors[a]!=infty?ancestors[a]:"infty"+" ";
				
		return res;
	}

	
}
