package com.chess.app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Rook extends Piece {

    public Rook(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\rook_" + color + ".png"),x,y,color);
    }


    public ArrayList<Position> getLegalSquares(Square[][] board_state){
        ArrayList<Position> legalMoves = new ArrayList<Position>();
        for(int i=position.xLocation + 1;i<8;i++)
        {
            if(!isPiece(board_state,i,position.yLocation))
                legalMoves.add(new Position(i,position.yLocation));
            else if(isEnemyPiece(board_state,i,position.yLocation))
            {    
                legalMoves.add(new Position(i,position.yLocation));
                break;
            }
            else break;
        }
        for(int i=position.xLocation - 1;i>-1;i--)
        {
            if(!isPiece(board_state,i,position.yLocation))
                legalMoves.add(new Position(i,position.yLocation));
            else if(isEnemyPiece(board_state,i,position.yLocation))
            {    
                legalMoves.add(new Position(i,position.yLocation));
                break;
            }
            else break;
        }
        for(int i=position.yLocation + 1;i<8;i++)
        {
            if(!isPiece(board_state,position.xLocation,i))
                legalMoves.add(new Position(position.xLocation,i));
            else if(isEnemyPiece(board_state,position.xLocation,i))
            {    
                legalMoves.add(new Position(position.xLocation,i));
                break;
            }
            else break;
        }
        for(int i=position.yLocation - 1;i>-1;i--)
        {
            if(!isPiece(board_state,position.xLocation,i))
                legalMoves.add(new Position(position.xLocation,i));
            else if(isEnemyPiece(board_state, position.xLocation,i))
            {    
                legalMoves.add(new Position(position.xLocation,i));
                break;
            }
            else break;
        }

        return legalMoves;

    }
    
}
