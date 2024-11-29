package pu.eightqueens;

import pu.services.StopWatch;

public class MainMetBitSet
{
public static void main( String [] args )
{
	for ( int rows = 4; rows <= 13; rows++ )
	{
		new MainMetBitSet().run( rows );
	}
}
private int numberOfSolutions = 0;
private Board board;

public void run( int aSquareBoardSize )
{
	StopWatch timer = new StopWatch();
	board = new BoardMetBitSet( aSquareBoardSize, aSquareBoardSize );
	runRow( 0, board );
	System.out.println( "Finished! Aantal oplossingen: " + numberOfSolutions + " time used: " + timer.getElapsedMs() );
}
public void runRow( int aRow, Board aBoard )
{
	for ( int col= 0; col < aBoard.getCols(); col++ )
	{
		if ( aBoard.isMoveAllowed( aRow, col ) )
		{
			aBoard.set( aRow, col );
			if ( aRow == aBoard.getRows() - 1 )
			{
				numberOfSolutions++;
				//System.out.println( aBoard + "------------------------------------" );
			}
			else
			{
				runRow( aRow + 1, aBoard );
			}
			aBoard.clear( aRow, col );
		}
	}
}


}
