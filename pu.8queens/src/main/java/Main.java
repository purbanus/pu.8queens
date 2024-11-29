

public class Main
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
	new Main().run();

}
private int numberOfSolutions = 0;

public void run()
{
	Board board = new Board( 11, 11 );
	runRow( 0, board );
	System.out.println( "Finished! Aantal oplossingen: " + numberOfSolutions );
}

public void runRow( int aCurrentRow, Board aBoard )
{
	for ( int col= 0; col < aBoard.cols; col++ )
	{
		if ( isMoveAllowed( aBoard, aCurrentRow, col ) )
		{
			aBoard.fields [aCurrentRow][col]  = 'x';
			if ( aCurrentRow == aBoard.rows - 1 )
			{
				numberOfSolutions++;
				System.out.println( aBoard + "------------------------------------" );
			}
			else
			{
				runRow( aCurrentRow + 1, aBoard );
			}
			aBoard.fields [aCurrentRow][col]  = ' ';
		}
	}
}

private boolean isMoveAllowed( Board aBoard, int aRow, int aCol )
{
	int row = aRow;
	int col =  aCol;
	
	// Naar linksboven
	row = aRow - 1;
	col = aCol - 1;
	while ( row >= 0 && col >= 0 )
	{
		if ( aBoard.fields [row][col] == 'x' )
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
		if ( aBoard.fields [row][col] == 'x' )
		{
			return false;
		}
		row -= 1;
	}

	// Naar rechtsboven
	row = aRow - 1;
	col = aCol + 1;
	while ( row >= 0 && col < aBoard.cols )
	{
		if ( aBoard.fields [row][col] == 'x' )
		{
			return false;
		}
		row -= 1;
		col += 1;
	}
	return true;
}



}
