package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class King extends Piece {

    public King(String color){
        super(new ImageIcon("src\\main\\resources\\king_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
