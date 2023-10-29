package com.chess.app;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Knight extends Piece {

    public Knight(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\knight_" + color + ".png"),x,y,color);
    }


    public ArrayList<Position> getLegalSquares(Square[][] board_state){
        ArrayList<Position> legalMoves = new ArrayList<Position>();
        legalMoves.add(new Position(position.xLocation + 2,position.yLocation + 1));
        legalMoves.add(new Position(position.xLocation + 2,position.yLocation - 1));
        legalMoves.add(new Position(position.xLocation + 1,position.yLocation + 2));
        legalMoves.add(new Position(position.xLocation + 1,position.yLocation - 2));
        legalMoves.add(new Position(position.xLocation - 2,position.yLocation + 1));
        legalMoves.add(new Position(position.xLocation - 2,position.yLocation - 1));
        legalMoves.add(new Position(position.xLocation - 1,position.yLocation + 2));
        legalMoves.add(new Position(position.xLocation - 1,position.yLocation - 2));

        ArrayList<Position> toRemove = new ArrayList<Position>();
        for (Position pos : legalMoves) 
        {
            if((isPiece(board_state, pos.xLocation, pos.yLocation) && !isEnemyPiece(board_state, pos.xLocation, pos.yLocation)) || outOfBounds(pos))
                toRemove.add(pos);
        }
        legalMoves.removeAll(toRemove);
        return legalMoves;
    }
    
    private boolean outOfBounds(Position pos)
    {
        return pos.xLocation > 7 || pos.xLocation < 0 || pos.yLocation > 7 || pos.yLocation < 0;
    }
}
