package pu.eightqueens;

import java.util.BitSet;

public class BoardMetBitSet extends AbstractBoard
{
private final BitSet fields;
public BoardMetBitSet( int aRows, int aCols )
{
	super( aRows, aCols );
	fields = new BitSet();
	fields.clear();
}
@Override
public boolean get( int aRow, int aCol )
{
	return fields.get( getRows() * aRow + aCol );
}
@Override
public void set( int aRow, int aCol )
{
	fields.set( getRows() * aRow + aCol );
}
@Override
public void clear( int aRow, int aCol )
{
	fields.clear( getRows() * aRow + aCol );
}

}
