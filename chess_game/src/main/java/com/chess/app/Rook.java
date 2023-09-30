package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Rook extends Piece {

    public Rook(String color){
        super(new ImageIcon("src\\main\\resources\\rook_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
