package all;

/**
 * Concurrent matrix multiplication
 * @author Felipe M.
 * @author Kevin W.
 *
 */
public class ConcurrentMultiplication implements MatrixOperator{
	
	private int cores;
	
	/**
	 * Constructor
	 * @param cores
	 */
	public ConcurrentMultiplication(int cores) {
		this.cores = cores;
	}
	
	/**
	 * Execute the multiplication of 2 matrices
	 * @param lhs
	 * @param rhs
	 */
	public Matrix execute(Matrix lhs, Matrix rhs){
		
		Matrix c = new Matrix(lhs.getN(), rhs.getM());
		
		int i = 0;
		
		Thread[] threads = new LineCalculation[cores];
		
		while (i<lhs.getM()) {
			for (int x = 0; x < cores; x++) {
				threads[x] = new LineCalculation(lhs,rhs,c,i, ("Thead " + x));
				LineCalculation lc = (LineCalculation) threads[x];
				
				if (i++ < lhs.getM()) {
					lc.start();
				}
				
			}
			
			for (int x = 0; x < cores; x++) {
				LineCalculation lc = (LineCalculation) threads[x];

				if (lc.isAlive())
					try {
						lc.join();
					} catch (InterruptedException e) {
						System.out.println("Issues with the threads!");
					}
			}
		}
		
		
		return c;
		
	}
}
