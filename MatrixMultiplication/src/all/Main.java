package all;

public class Main {

	public static void main(String[] args) {
		
		// 3 parâmetros, quantidade de execuções
		// Se tiver o all, setar o booleano para true
		if(args.length < 2) 
		{
			System.out.println("Quantidade de parâmetros inválida!!!");
		}
		else 
		{
			int d;
			int iterations = 1;
			boolean all = false;
			String type;
			
			d = Integer.parseInt(args[0]);
			type = args[1].toLowerCase();
			
			if(args.length == 3) 
			{
				iterations = Integer.parseInt(args[2]);
			}
			else if(args.length == 4) 
			{
				iterations = Integer.parseInt(args[2]);
				
				if(args[3].equals("all")) 
				{
					all = true;
				}
			}

			Matrix m;
			
			if(type.equals("sc") || type.equals("cs")) 
			{
				MatrixOperator op = new ConcurrentMultiplication(12);
				
				IOManager iomanager = new IOManager("data/", d);
				
				m = op.execute(iomanager.getLHS(), iomanager.getRHS());
				
				op = new SequentialMultiplication();
				
				m = op.execute(iomanager.getLHS(), iomanager.getRHS());
				
				iomanager.writeMatrixFile(m);
			}
			else if(type.equals("c")) 
			{
				MatrixOperator op = new ConcurrentMultiplication(12);
				
				IOManager iomanager = new IOManager("data/", d);
				
				m = op.execute(iomanager.getLHS(), iomanager.getRHS());
				
				iomanager.writeMatrixFile(m);
			}
			else if(type.equals("s")) 
			{
				MatrixOperator op = new SequentialMultiplication();;
				
				IOManager iomanager = new IOManager("data/", d);
				
				m = op.execute(iomanager.getLHS(), iomanager.getRHS());
				
				iomanager.writeMatrixFile(m);
			}
			else 
			{
				System.out.println("O segundo parâmetro fornecido é inválido!!!");
			}
		}	
	}
	
}
