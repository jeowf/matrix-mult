package all;

public class Matrix {

	private float[][] matrix;
	
	private int m,n; 
	
	public Matrix(float[][] matrix, int m, int n) {
		
		this.m = m;
		this.n = n;
		
		this.matrix = matrix;
	}

	public Matrix(int m, int n) {
		
		this.m = m;
		this.n = n;
		
		this.matrix = new float[m][n];
	}
	
	public float[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(float[][] matrix) {
		this.matrix = matrix;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
	
}
