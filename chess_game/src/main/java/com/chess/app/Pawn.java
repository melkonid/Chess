package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

    public Pawn(String color){
        super(new ImageIcon("src\\main\\resources\\pawn_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
