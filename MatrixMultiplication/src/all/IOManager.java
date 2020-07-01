package all;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOManager {
	
	private final static String LHS_PREFFIX = "A";
	private final static String RHS_PREFFIX = "B";
	private final static String EXTENSION = ".txt";
	
	private String path;
	
	private int d;
	
	
	public IOManager(String path, int d) {
		this.path = path;
		this.d = d;
			
		
	}
	
	public Matrix getLHS() {
		return readMatrixFile(LHS_PREFFIX, d);
	}
	
	public Matrix getRHS() {
		return readMatrixFile(RHS_PREFFIX, d);
	}
	
	public Matrix readMatrixFile(String preffix, int d) {
		Matrix matrix = null;
		
		String filePath = this.path + preffix + d + "x" + d + EXTENSION;
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(filePath));
			
			String line;
			
			line = file.readLine();
			String[] dimensions = line.split(" ");
			
			int m = Integer.parseInt(dimensions[0]);
			int n = Integer.parseInt(dimensions[1]);
			
			int i = 0;
			
			float[][] m_aux = new float[m][n];;
			
			while((line = file.readLine()) != null) {
				String[] fields = line.split(" ");
				
				
				for (int j = 0; j < n; j++) {
					m_aux[i][j] = Float.parseFloat(fields[j]);
				}
				
				i++;
			}
			
			matrix = new Matrix(m_aux, m, n);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		
		return matrix;
	}
	
}
