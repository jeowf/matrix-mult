package all;

/**
 * Generalization of matrix operator
 * @author Felipe M.
 *
 */
public interface MatrixOperator
{
	/**
	 * Execute the operator between the 2 matrices
	 * @param lhs
	 * @param rhs
	 * @return resulting matrix
	 */
	public Matrix execute(Matrix lhs, Matrix rhs);
}
