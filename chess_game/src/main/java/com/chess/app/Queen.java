package com.chess.app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Queen extends Piece {

    public Queen(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\queen_" + color + ".png"),x,y,color);
    }


    public ArrayList<Position>getLegalSquares(){
        ArrayList<Position> legalMoves = new ArrayList<Position>();


        return legalMoves;

    }
    
}
