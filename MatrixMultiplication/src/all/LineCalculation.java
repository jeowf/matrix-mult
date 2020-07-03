package all;

/**
 * Calculation of a row in the new matrix
 * @author Felipe M.
 *
 */
public class LineCalculation extends Thread {

	private Matrix a;
	private Matrix b;
	private Matrix c;
	private int i;
	
	/**
	 * Constructor
	 * @param a
	 * @param b
	 * @param c
	 * @param i
	 * @param name
	 */
	public LineCalculation(Matrix a, Matrix b, Matrix c, int i, String name) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
		this.i = i;
	}
	
	/**
	 * Calculate the row's values
	 * 
	 */
	@Override
	public void run() {
		for(int j = 0; j < b.getM(); j++)
		{
			float somaLinha = 0;
			
			for(int k = 0; k < a.getM(); k++) 
			{
				somaLinha = somaLinha + (a.at(i,k) * b.at(k, j));
			}
			
			c.add(i, j, somaLinha);
		}
	}
	
	
	public Matrix getA() {
		return a;
	}




	public void setA(Matrix a) {
		this.a = a;
	}




	public Matrix getB() {
		return b;
	}




	public void setB(Matrix b) {
		this.b = b;
	}




	public Matrix getC() {
		return c;
	}




	public void setC(Matrix c) {
		this.c = c;
	}




	public int getI() {
		return i;
	}




	public void setI(int i) {
		this.i = i;
	}

}
