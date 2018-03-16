import java.util.* ;

public class matrix_multiplication
{
	public static void main(String[] args)
	{
		int i, j, k ;
		Random obj = new Random() ;
		Scanner input = new Scanner(System.in) ;
		
		System.out.print("Enter the order of the matrix :- ") ;
		int n = input.nextInt() ;
		
		int[][] X = new int[n][n] ;
		int[][] Y = new int[n][n] ;
		int[][] Z = new int[n][n] ;
		
		System.out.println("\n\nMatrix X :- \n\n") ;
		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n ; j++)
			{
				X[i][j] = obj.nextInt(9) ;
				System.out.print(X[i][j] + "\t") ;
			}
			System.out.println("\n\n") ;
		}

		System.out.println("\n\nMatrix Y :- \n\n") ;
		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n ; j++)
			{
				Y[i][j] = obj.nextInt(9) ;
				System.out.print(Y[i][j] + "\t") ;
			}
			System.out.println("\n\n") ;
		}

		System.out.println("\n\nProduct matrix Z :-\n\n") ;
		
		long begin = System.nanoTime() ;
		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n; j++)
			{
				for(k = 0 ; k < n ; k++)
				{
					Z[i][j] = Z[i][j] + X[i][k] * Y[k][j] ;
				}
			}
		}
		long end = System.nanoTime() ;
		
		double time = (end - begin) / 1000000000.0 ;
		
		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ; j < n; j++)
			{
				System.out.print(Z[i][j] + "\t") ;
			}
			System.out.println("\n\n") ;
		}

		System.out.println("\n\nTime taken is :- " + time + " seconds\n\n") ;
	}
}