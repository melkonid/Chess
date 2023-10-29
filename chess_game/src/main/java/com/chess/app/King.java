package com.chess.app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class King extends Piece {

    public King(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\king_" + color + ".png"),x,y,color);
    }


    public ArrayList<Position> getLegalSquares(){
        ArrayList<Position> legalMoves = new ArrayList<Position>();


        return legalMoves;

    }
    
}
