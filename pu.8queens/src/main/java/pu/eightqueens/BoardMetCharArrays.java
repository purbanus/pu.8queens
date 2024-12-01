package pu.eightqueens;

public class BoardMetCharArrays extends AbstractBoard
{
public char [][] fields;
public BoardMetCharArrays( int aRows, int aCols )
{
	super( aRows, aCols );
	fields = new char[getRows()][getCols()];
	for ( int row = 0; row < getRows(); row++ )
	{
		for ( int col = 0; col < getCols(); col++ )
		{
			fields [row][col] = ' '; 
		}
	}
}
@Override
public boolean get( int aRow, int aCol )
{
	return fields[aRow][aCol] == 'o';
}
@Override
public void set( int aRow, int aCol )
{
	fields[aRow][aCol] = 'o';
}
@Override
public void clear( int aRow, int aCol )
{
	fields[aRow][aCol] = ' ';
}
}