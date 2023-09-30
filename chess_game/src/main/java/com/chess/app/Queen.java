package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Queen extends Piece {

    public Queen(String color){
        super(new ImageIcon("src\\main\\resources\\queen_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
