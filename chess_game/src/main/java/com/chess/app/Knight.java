package com.chess.app;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Knight extends Piece {

    public Knight(String color){
        super(new ImageIcon("src\\main\\resources\\knight_" + color + ".png"));
    }


    public HashMap<Integer,Integer> getLegalSquares(){
        HashMap<Integer,Integer> legalMoves = new HashMap<Integer,Integer>();


        return legalMoves;

    }
    
}
