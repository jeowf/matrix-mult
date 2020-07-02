package all;

public class Main {

	public static void main(String[] args) {
		
		int d = 2048;
		
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println(cores);
		
		IOManager iomanager = new IOManager("data/", d);
		
		MatrixOperator mSeq = new ConcurrentMultiplication(12);
		
		//MatrixOperator mSeq = new SequentialMultiplication();
		
		Matrix m = mSeq.execute(iomanager.getLHS(), iomanager.getRHS());
		
		iomanager.writeMatrixFile(m);
		
		
		
		System.out.println("Finished");
	}
	
}
