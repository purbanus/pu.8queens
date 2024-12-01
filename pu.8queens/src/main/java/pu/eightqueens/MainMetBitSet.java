package pu.eightqueens;

import java.util.List;

import pu.services.MatrixFormatter;
import pu.services.MatrixFormatter.Alignment;
import pu.services.StopWatch;
import pu.services.StringHelper;

public class MainMetBitSet
{
public static void main( String [] args )
{
	MatrixFormatter matrixFormatter = new MatrixFormatter();
	matrixFormatter.setDefaultAlignment( MatrixFormatter.ALIGN_RIGHT );
	matrixFormatter.addHeader( StringHelper.repChar( '-', 50 ) );
	matrixFormatter.addDetail( new String [] { "Zijde", "Aantal Oplossingen", "Tijd" } );
	matrixFormatter.addHeader( StringHelper.repChar( '-', 50 ) );
	for ( int rows = 1; rows <= 15; rows++ )
	{
		new MainMetBitSet().run( rows, matrixFormatter );
	}
	matrixFormatter.addHeader( StringHelper.repChar( '-', 50 ) );
	System.out.println( matrixFormatter.getOutput() );
}
private int numberOfSolutions = 0;
private Board board;

public void run( int aSquareBoardSize, MatrixFormatter aMatrixFormatter )
{
	StopWatch timer = new StopWatch();
	board = new BoardMetBitSet( aSquareBoardSize, aSquareBoardSize );
	runRow( 0, board );
	//System.out.println( "Zijde = " + aSquareBoardSize + " Aantal oplossingen: " + numberOfSolutions + " time used: " + timer.getElapsedMs() );
	aMatrixFormatter.addDetail( aSquareBoardSize + "\t" + numberOfSolutions + "\t" + timer.getElapsed() );
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
