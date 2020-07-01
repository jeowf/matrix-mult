import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Matrix 
{
	private int data[][];
	private int lin;
	private int col;
	
	public void read(String FileName) 
	{
		FileReader file;
		
		try 
		{
			file = new FileReader(FileName);
			this.lin = file.read();
			this.col = file.read();
			this.data = new int[lin][col];
			
			for(int i = 0; i < this.lin; i++) 
			{
				for(int j = 0; j < this.col; j++) 
				{
					this.data[i][j] = file.read();
				}
			}
			
			file.close();
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Erro na abertura do arquivo");
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			System.out.println("Erro na leitura dos dados");
			e.printStackTrace();
		}
	}
	
	public void print() 
	{
		for(int i = 0; i < this.lin; i++) 
		{
			System.out.print("| ");
			for(int j = 0; j < this.col; j++) 
			{
				System.out.print(this.data[i][j]+" ");
			}
			System.out.println("|");
		}
	}
	
	public int at(int i, int j) 
	{
		return data[i][j];
	}
	
	public void add(int i, int j, int val) 
	{
		data[i][j] = val;
	}
}
