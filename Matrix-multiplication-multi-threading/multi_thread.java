import java.util.* ;

class product_matrix extends Thread
{
	private int[][] P ;
    private int[][] Q ;
    private int[][] R ;
    private int n, i, j, k, a ;

    public product_matrix(int[][] X, int[][] Y, int[][] Z, int x, int m)
    {
    	P = X ;
    	Q = Y ;
    	R = Z ;
    	i = x ;
    	n = m ;
    }

    public void run()
    {
    	for(k = 0 ; k < n ; k++)
    	{
    		for(a = 0 ; a < n ; a++)
    		{
    			R[i][k] = R[i][k] + P[i][a] * Q[a][k] ;
    		}
    	}
    }
}

public class multi_thread
{
	public static void main(String[] args)
	{
		int i, j, k ;
		Scanner In = new Scanner(System.in) ;
		Random obj = new Random() ;

		System.out.print("Enter the order of the matrix :- ") ;
		int n = In.nextInt() ;

		int[][] X = new int[n][n];
    	int[][] Y = new int[n][n];
    	int[][] Z = new int[n][n];

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

		long begin = System.nanoTime() ;

		for(i = 0 ; i < n ; i++)
		{
			product_matrix object = new product_matrix(X, Y, Z, i, n) ;
			object.start() ;
			try
			{
				object.join() ;
			}
			catch(Exception e){}
		}

		long end = System.nanoTime() ;

		double time = (end - begin) / 1000000000.0 ;

		System.out.println("\n\nThe Product matrix Z is :- \n\n") ;

		for(i = 0 ; i < n ; i++)
		{
			for(j = 0 ;j < n ; j++)
			{
				System.out.print(Z[i][j] + "\t") ;
			}
			System.out.println("\n\n") ;
		}

		System.out.println("\n\nThe time taken is " + time + " seconds\n\n") ;
	}
}