package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public abstract class Piece {

    protected ImageIcon pieceImage;

    public Piece(ImageIcon i)
    {
        pieceImage = i;
    }

    public ImageIcon getIcon()
    {
        return pieceImage;
    }

    public void setIcon(ImageIcon i)
    {
        pieceImage = i;
    }
    public abstract HashMap<Integer,Integer> getLegalSquares();
    
}
