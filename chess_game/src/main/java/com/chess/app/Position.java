package com.chess.app;

public class Position {
    public int xLocation;
    public int yLocation;


    public Position(int x, int y)
    {
        xLocation = x;
        yLocation = y;
    }

    public boolean comparePos(Position pos2)
    {
        return xLocation == pos2.xLocation && yLocation == pos2.yLocation;
    }
    
    @Override
    public boolean equals(Object pos)
    {
        Position position = (Position) pos;
        return comparePos(position);
    }
}
