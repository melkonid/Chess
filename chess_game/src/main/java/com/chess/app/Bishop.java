package com.chess.app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Bishop extends Piece {

    public Bishop(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\bishop_" + color + ".png"),x,y,color);
    }


    public ArrayList<Position> getLegalSquares(Square[][] board_state){
        ArrayList<Position> legalMoves = new ArrayList<Position>();
        for(int i=position.xLocation + 1, j=position.yLocation + 1; i<8 && j<8; i++,j++)
        {
            if(!isPiece(board_state, i, j))
                legalMoves.add(new Position(i, j));
            else if(isEnemyPiece(board_state, i, j))
            {
                legalMoves.add(new Position(i, j));
                break;
            }
            else break;
        }
        for(int i=position.xLocation - 1, j=position.yLocation + 1; i>-1 && j<8; i--,j++)
        {
            if(!isPiece(board_state, i, j))
                legalMoves.add(new Position(i, j));
            else if(isEnemyPiece(board_state, i, j))
            {
                legalMoves.add(new Position(i, j));
                break;
            }
            else break;
        }
        for(int i=position.xLocation + 1, j=position.yLocation - 1; i<8 && j>-1; i++,j--)
        {
            if(!isPiece(board_state, i, j))
                legalMoves.add(new Position(i, j));
            else if(isEnemyPiece(board_state, i, j))
            {
                legalMoves.add(new Position(i, j));
                break;
            }
            else break;
        }
        for(int i=position.xLocation - 1, j=position.yLocation - 1; i>-1 && j>-1; i--,j--)
        {
            if(!isPiece(board_state, i, j))
                legalMoves.add(new Position(i, j));
            else if(isEnemyPiece(board_state, i, j))
            {
                legalMoves.add(new Position(i, j));
                break;
            }
            else break;
        }
        return legalMoves;

    }
    
}
