package pu.eightqueens;

public interface Board
{
public abstract void set( int aRow, int aCol );
public abstract void clear( int aRow, int aCol );
public abstract boolean get( int aRow, int aCol );
public abstract boolean isMoveAllowed( int aRow, int aCol );
public abstract int getRows();
public abstract int getCols();

}
