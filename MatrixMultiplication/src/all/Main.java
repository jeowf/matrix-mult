package all;

public class Main {

	public static void main(String[] args) {
		
		IOManager iomanager = new IOManager("data/", 4);
		
		Matrix m = iomanager.getLHS();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(m.getMatrix()[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
}
