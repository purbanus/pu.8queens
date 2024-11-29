package pu.eightqueens;

import pu.services.StringHelper;

public abstract class AbstractBoard implements Board
{

private final int rows;
private final int cols;

public AbstractBoard( int aRows, int aCols )
{
	super();
	rows = aRows;
	cols = aCols;
}
@Override
public int getRows()
{
	return rows;
}
@Override
public int getCols()
{
	return cols;
}

@Override
public boolean isMoveAllowed( int aRow, int aCol )
{
	int row = aRow;
	int col =  aCol;
	
	// Naar linksboven
	row = aRow - 1;
	col = aCol - 1;
	while ( row >= 0 && col >= 0 )
	{
		if ( get( row, col ) )
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
		if ( get( row, col ) )
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
		if ( get( row, col ) )
		{
			return false;
		}
		row -= 1;
		col += 1;
	}
	return true;
}
//|--|--|--|--|
//|  |o |  |  |
//|--|--|--|--|
//|  |  |  |o |
//|--|--|--|--|
//|o |  |  |  |
//|--|--|--|--|
//|  |  |o |  |
//|--|--|--|--|
@Override
public String toString()
{	String horLine = "+" + StringHelper.repString( "--+", cols ) + "\n";
	StringBuilder boardString = new StringBuilder();
	boardString.append( horLine );
	for ( int row = 0; row < rows; row++ )
	{
		StringBuilder rowString = new StringBuilder();
		rowString.append( "|" );
		for ( int col = 0; col < cols; col++ )
		{
			rowString.append( get( row, col ) ? "o |" : "  |" );
		}
		boardString.append( rowString ).append( "\n" );
		boardString.append( horLine );
	}
	return boardString.toString();
}

}