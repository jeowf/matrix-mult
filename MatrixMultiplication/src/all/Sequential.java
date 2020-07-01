package all;

public class Sequential extends Multiplicator
{
	public Matrix multiply(Matrix a, Matrix b) 
	{
		Matrix c = new Matrix(a.getN(), b.getM());
		
		for(int i = 0; i < a.getN(); i++) 
		{
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
		
		return c;
	}
}
