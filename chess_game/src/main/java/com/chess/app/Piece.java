package com.chess.app;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Piece {

    protected ImageIcon pieceImage;
    protected Position position;
    protected int color;
    boolean has_moved = false;

    public Piece(ImageIcon i, int x, int y,String color)
    {
        pieceImage = i;
        position = new Position(x, y);
        this.color = 1;
        if(color.equals("w"))
        {
            this.color = -1;
        }
    }

    public ImageIcon getIcon()
    {
        return pieceImage;
    }

    public void setIcon(ImageIcon i)
    {
        pieceImage = i;
    }
    public abstract ArrayList<Position> getLegalSquares(Square[][] board_state);

    public void setPosition(Position p)
    {
        position = p;
    }

    protected boolean outOfbounds(Square[][] board_state,int x,int y)
    {
        if(x > 7 || x < 0 || y > 7 || y < 0) return true;
        return false;
    }

    protected boolean isPiece(Square[][] board_state,int x,int y)
    {
        //Out of bounds
        if(x > 7 || x < 0 || y > 7 || y < 0) return false;
        return board_state[x][y].getPiece() != null;
    }

    protected boolean isEnemyPiece(Square[][] board_state,int x,int y)
    {
        return board_state[x][y].getPiece().color != this.color;
    }

    public void moved()
    {
        has_moved = true;
    }

    public boolean getMoved()
    {
        return has_moved;
    }
    
}
