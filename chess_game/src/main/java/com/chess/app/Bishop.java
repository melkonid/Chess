package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Bishop extends Piece {

    public Bishop(String color){
        super(new ImageIcon("src\\main\\resources\\bishop_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
