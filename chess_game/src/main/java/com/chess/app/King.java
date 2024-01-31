package com.chess.app;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class King extends Piece {

    private int start_x,start_y;
    public King(String color,int x, int y){
        super(new ImageIcon("src\\main\\resources\\king_" + color + ".png"),x,y,color);
        start_x = x;
        start_y = y;
    }


    public ArrayList<Position> getLegalSquares(Square [][] boardSquares){
        ArrayList<Position> legalMoves = new ArrayList<Position>();
        for(int i= position.xLocation - 1;i<=position.xLocation + 1;i++)
        {
            for(int j=position.yLocation - 1;j<= position.yLocation + 1;j++)
            {
                if(outOfbounds(boardSquares,i,j)) 
                    continue;
                if(!isPiece(boardSquares, i, j))
                    legalMoves.add(new Position(i, j));
                else if (isEnemyPiece(boardSquares, i, j)) 
                    legalMoves.add(new Position(i, j));
            }
        }

        
        if(!has_moved && position.xLocation == start_x && position.yLocation == start_y)
        {
            //Kingside castle
            if(boardSquares[position.xLocation][position.yLocation+1].getPiece() == null &&
            boardSquares[position.xLocation][position.yLocation+2].getPiece() == null)
            {
                try{
                    Rook rook_king_side = (Rook) boardSquares[position.xLocation][position.yLocation + 3].getPiece();
                    if(rook_king_side.castle())
                    {
                        legalMoves.add(new Position(position.xLocation, position.yLocation + 2));
                    }
                }
                catch(Exception e){System.out.println(position.xLocation + "," + position.yLocation + 2 );}
            }

            //Queenside castle
            if(boardSquares[position.xLocation][position.yLocation-1].getPiece() == null &&
            boardSquares[position.xLocation][position.yLocation-2].getPiece() == null &&
            boardSquares[position.xLocation][position.yLocation-3].getPiece() == null)
            {
                try{
                    Rook rook_queen_side = (Rook) boardSquares[position.xLocation][position.yLocation - 4].getPiece();
                    if(rook_queen_side.castle())
                    {
                        legalMoves.add(new Position(position.xLocation, position.yLocation - 3));
                    }
                }
                catch(Exception e){System.out.println(position.xLocation + "," + position.yLocation + 2 );}
            }
        }

        //remove controlled squares
        return legalMoves;

    }
    
}
