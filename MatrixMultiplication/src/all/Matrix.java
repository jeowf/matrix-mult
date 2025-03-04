package all;

/**
 * Matrix
 * @author Felipe M.
 * @author Kevin W.
 *
 */
public class Matrix {

	private float[][] matrix;
	
	private int m,n; 
	
	/**
	 * Constructor
	 * @param matrix
	 * @param m
	 * @param n
	 */
	public Matrix(float[][] matrix, int m, int n) {
		
		this.m = m;
		this.n = n;
		
		this.matrix = matrix;
	}

	/**
	 * Costruct a matrix with 0's
	 * @param m
	 * @param n
	 */
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
	
	public float at(int i, int j) 
	{
		return this.matrix[i][j];
	}
	
	public void add(int i, int j, float value) 
	{
		this.matrix[i][j] = value;
	}
}
