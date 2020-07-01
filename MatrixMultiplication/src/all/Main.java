package all;

public class Main {

	public static void main(String[] args) {
		
		int d = 4;
		
		IOManager iomanager = new IOManager("data/", d);
		
		MatrixOperator mSeq = new SequentialMultiplication();
		
		Matrix m = mSeq.execute(iomanager.getLHS(), iomanager.getRHS());
		
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				System.out.print(m.getMatrix()[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
}
