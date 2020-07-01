package all;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOManager {
	
	private final static String LHS_PREFFIX = "A";
	private final static String RHS_PREFFIX = "B";
	private final static String ANSWER_PREFFIX = "C";
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
	
	public void writeMatrixFile(Matrix matrix) {
		
		String filePath = this.path + ANSWER_PREFFIX + d + "x" + d + EXTENSION;
		try 
		{
		    String str = matrix.getN() + " " + matrix.getM() + "\n";
		    
		    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		    
		    writer.append(str);
		    
		    for(int i = 0; i < matrix.getN(); i++) 
		    {
		    	str = "";
		    	for(int j = 0; j < matrix.getM(); j++) 
		    	{
		    		str = str.concat(matrix.at(i, j) + " ");
		    	}
		    	str = str.concat("\n");
		    	writer.append(str);
		    }
		     
		    writer.close();
		}
		catch(IOException e)
		{
			System.out.println("Erro na criação do arquivo da matriz resposta");
			e.printStackTrace();
		}
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
			System.out.println("Arquivo " + filePath + " não encontrado.");
			e.printStackTrace();
		} 
		
		
		return matrix;
	}
	
}
