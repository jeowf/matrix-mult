package all;

public class ConcurrentMultiplication implements MatrixOperator{
	
	private int cores;
	
	public ConcurrentMultiplication(int cores) {
		this.cores = cores;
	}
	
	public Matrix execute(Matrix a, Matrix b){
		
		Matrix c = new Matrix(a.getN(), b.getM());
		
		int i = 0;
		
		Thread[] threads = new LineCalculation[cores];
		
		while (i<a.getM()) {
			for (int x = 0; x < cores; x++) {
				threads[x] = new LineCalculation(a,b,c,i, ("Thead " + x));
				LineCalculation lc = (LineCalculation) threads[x];
				
				if (i++ < a.getM()) {
					lc.start();
				}
				
			}
			
			for (int x = 0; x < cores; x++) {
				LineCalculation lc = (LineCalculation) threads[x];

				if (lc.isAlive())
					try {
						lc.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
		
		
		return c;
		
	}
}
