package all;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// 3 parâmetros, quantidade de execuções
		// Se tiver o all, setar o booleano para true
		if(args.length < 2)  {
			System.out.println("Quantidade de parâmetros inválida!!!");
			System.exit(0);
		} 
		
		int d = 0;
		int iterations = 1;
		boolean all = false;
		String type;
		
		int[] allFiles = {4,8,16,32,64,128,256,512,1024,2048};
		
		// reading first parameter
		try {
			d = Integer.parseInt(args[0]);
		} catch(Exception e) {
			System.out.println("Invalid number of dimension!");
		}
		
		// reading second parameter
		type = args[1].toLowerCase();
		
		// reading third parameter (optional)
		if(args.length >= 3) {
			try {
				iterations = Integer.parseInt(args[2]);
			} catch(Exception e) {
				System.out.println("Invalid number of interations!");
			}
			
		} 
		
		// reading fourth parameter (optional)
		if(args.length == 4 && args[3].equals("all")) {
			all = true;
		} 

		Matrix m;
		
		IOManager iomanager = new IOManager("data/", d);
		
		List<MatrixOperator> matrixOperators = new ArrayList<MatrixOperator>();
		
		if(type.equals("sc") || type.equals("cs")) {
			
			matrixOperators.add(new SequentialMultiplication());
			matrixOperators.add(new ConcurrentMultiplication(Runtime.getRuntime().availableProcessors()));
			
			/*
			
			m = op.execute(iomanager.getLHS(), iomanager.getRHS());
			
			op = new SequentialMultiplication();
			
			m = op.execute(iomanager.getLHS(), iomanager.getRHS());
			
			iomanager.writeMatrixFile(m);
			*/
		} else if(type.equals("c")) {
			matrixOperators.add(new ConcurrentMultiplication(Runtime.getRuntime().availableProcessors()));
			
			//IOManager iomanager = new IOManager("data/", d);
			/*
			m = op.execute(iomanager.getLHS(), iomanager.getRHS());
			
			iomanager.writeMatrixFile(m);
			*/
		} else if(type.equals("s")) {
			matrixOperators.add(new SequentialMultiplication());
			
			//IOManager iomanager = new IOManager("data/", d);
			/*
			m = op.execute(iomanager.getLHS(), iomanager.getRHS());
			
			iomanager.writeMatrixFile(m);
			*/
		} else {
			System.out.println("Invalid algorithm! Choose S or C!");
		}
		
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("data/out.txt"));
		
		
			for (MatrixOperator op : matrixOperators) {
				
				System.out.println("Using " + op.getClass().getName() + " operator");
				output.append( op.getClass().getName() + "\n");
				
				if (!all) {
					allFiles = new int[1];
					allFiles[0] = d;
				}
					
				for (int mat : allFiles) {
					System.out.println("Using " + mat + " as current dimension.");
					output.append("" + mat + ":");					
					
					iomanager.setD(mat);
					Matrix result = null;
					
					long total = 0;
					
					for (int i = 0; i < iterations; i++) {
						long startTime = System.nanoTime();
						result = op.execute(iomanager.getLHS(), iomanager.getRHS());
						long endTime = System.nanoTime();
						output.append("" + (endTime-startTime) + " ");
						
						total += (endTime-startTime);
						
					}
					output.append("\n");
					
					total /= iterations;
					
					System.out.println("AVG elapsed time " + total + " nanoseconds (" + iterations + " iterations)");
					iomanager.writeMatrixFile(result);
				}
				
				output.append("\n");				
			}
			
			output.close();

		} catch (IOException e) {
			System.out.println("Cannot create the output file!");
		}
		//programa 4 cs 20  all
		
	}	
	
	
}
