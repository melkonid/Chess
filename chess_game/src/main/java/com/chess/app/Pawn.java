package com.chess.app;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Pawn extends Piece {
    private Position startPosition;
    private boolean an_passant;
    

    public Pawn(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\pawn_" + color + ".png"),x,y,color);
        startPosition = new Position(x, y) ;
    }


    public ArrayList<Position> getLegalSquares(Square[][] board_state){
        ArrayList<Position> legalMoves = new ArrayList<Position>();
        //check if blocked by piece
        if(!isPiece(board_state,position.xLocation + 1 * color,position.yLocation))
            legalMoves.add(new Position(position.xLocation + 1 * color, position.yLocation));
        //Add +2 if first move && not blocked
        if(position.comparePos(startPosition) && !isPiece(board_state,position.xLocation + 2 * color, position.yLocation))
            legalMoves.add(new Position(position.xLocation + 2 * color, position.yLocation ));
        //Capture 1 left
        if(isPiece(board_state,position.xLocation + 1 * color, position.yLocation - 1) && isEnemyPiece(board_state,position.xLocation + 1 * color, position.yLocation - 1))
            legalMoves.add(new Position(position.xLocation + 1 * color, position.yLocation - 1));
        //Capture 1 right
        if(isPiece(board_state,position.xLocation + 1 * color, position.yLocation + 1) && isEnemyPiece(board_state,position.xLocation + 1 * color, position.yLocation + 1))
            legalMoves.add(new Position(position.xLocation + 1 * color, position.yLocation + 1));
        //An Passant
        //Promote

        return legalMoves;
    }
    
}
