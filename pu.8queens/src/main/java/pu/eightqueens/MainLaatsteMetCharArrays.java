package pu.eightqueens;

import pu.services.StopWatch;

public class MainLaatsteMetCharArrays
{
public static class Board
{
public final int rows;
public final int cols;

public final char [][] fields;
public Board( int aRows, int aCols )
{
	rows = aRows;
	cols = aCols;
	fields = new char[rows][cols];
	for ( int row = 0; row < rows; row++ )
	{
		for ( int col = 0; col < cols; col++ )
		{
			fields [row][col] = ' '; 
		}
	}
}
public boolean isMoveAllowed( int aRow, int aCol )
{
	int row = aRow;
	int col =  aCol;
	
	// Naar linksboven
	row = aRow - 1;
	col = aCol - 1;
	while ( row >= 0 && col >= 0 )
	{
		if ( fields [row][col] == 'x' )
		{
			return false;
		}
		row -= 1;
		col -= 1;
	}
	
	// Naar boven
	row = aRow - 1;
	col = aCol;
	while ( row >= 0 )
	{
		if ( fields [row][col] == 'x' )
		{
			return false;
		}
		row -= 1;
	}

	// Naar rechtsboven
	row = aRow - 1;
	col = aCol + 1;
	while ( row >= 0 && col < cols )
	{
		if ( fields [row][col] == 'x' )
		{
			return false;
		}
		row -= 1;
		col += 1;
	}
	return true;
}
@Override
public String toString()
{
	StringBuilder boardString = new StringBuilder();
	for ( int row = 0; row < rows; row++ )
	{
		StringBuilder rowString = new StringBuilder();
		for ( int col = 0; col < cols; col++ )
		{
			rowString.append( fields [row][col] );
		}
		boardString.append(  rowString ).append( "\n" );
	}
	return boardString.toString();
}
}
public static void main( String [] args )
{
	new MainLaatsteMetCharArrays().run();

}
private int numberOfSolutions = 0;

public void run()
{
	StopWatch timer = new StopWatch();
	Board board = new Board( 5, 5 );
	runRow( 0, board );
	System.out.println( "Finished! Aantal oplossingen: " + numberOfSolutions + " time used: " + timer.getElapsedMs() );
}

public void runRow( int aRow, Board aBoard )
{
	for ( int col= 0; col < aBoard.cols; col++ )
	{
		if ( aBoard.isMoveAllowed( aRow, col ) )
		{
			aBoard.fields [aRow][col]  = 'x';
			if ( aRow == aBoard.rows - 1 )
			{
				numberOfSolutions++;
				//System.out.println( aBoard + "------------------------------------" );
			}
			else
			{
				runRow( aRow + 1, aBoard );
			}
			aBoard.fields [aRow][col]  = ' ';
		}
	}
}


}
