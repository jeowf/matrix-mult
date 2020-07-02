package all;

/**
 * Sequential matrix multiplication
 * @author Kevin W.
 *
 */
public class SequentialMultiplication implements MatrixOperator
{
	/**
	 * Execute the multiplication of 2 matrices
	 * @param lhs
	 * @param rhs
	 */
	public Matrix execute(Matrix lhs, Matrix rhs) 
	{
		Matrix c = new Matrix(lhs.getN(), rhs.getM());
		
		for(int i = 0; i < lhs.getN(); i++) 
		{
			for(int j = 0; j < rhs.getM(); j++)
			{
				float somaLinha = 0;
				
				for(int k = 0; k < lhs.getM(); k++) 
				{
					somaLinha = somaLinha + (lhs.at(i,k) * rhs.at(k, j));
				}
				
				c.add(i, j, somaLinha);
			}			
			
		}
		
		return c;
	}
}
