package com.chess.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Board implements ActionListener
{
    private int turnPlayer = -1;

    private JFrame field = new JFrame("Chess");      //Title!
    private JPanel panel=new JPanel();                  //Panel to add buttons 
    private GridLayout grid = new GridLayout (8,8);     //Grid layout so the buttons don't strech 


    Square board_squares[][]=new Square[8][8];          //Array to keep up to date with whats happening on board and use some other squares other like the one called method
    Square selected_piece = null;
    //Square move_square = null;                            // Two square variable to keep track with previous and this square pressed
    
    public Board ()
    {   
        field.setSize(800,800);                         
        field.setContentPane(panel);
        
        panel.setLayout(grid);
        iniateBoard();
        addPieces();
        
    }

    private void iniateBoard()
    {
        for(int i=0;i<8;i++)
        { 
            int counter=i;                     // A variable to keep up what color should the square be (go from 0-7 add white-black-white...then in next go I need it to have the same color as the last one)
            for(int j=0;j<8;j++)               // Double for loop to initialise board 
            {   
                if(counter%2 == 0)
                {
                    board_squares[i][j] = new Square(i,j,Color.WHITE,null,board_squares); 
                }
                else{
                    board_squares[i][j] = new Square(i,j,Color.GREEN.darker(),null,board_squares);
                }
                board_squares[i][j].getBox().addActionListener(this);
                panel.add(board_squares[i][j].getBox());
                counter++;
            }
        }
        changeBoard(); // add changes to board to start game
    }

    private void addPieces()
    {
        //Pawns
        for(int i=0;i<8;i++)
        { 
            board_squares[1][i].setPiece(new Pawn("b",1,i));
            board_squares[6][i].setPiece(new Pawn("w",6,i));
        }
        //Rooks
        board_squares[0][7].setPiece(new Rook("b",0,7));
        board_squares[0][0].setPiece(new Rook("b",0,0));
        board_squares[7][0].setPiece(new Rook("w",7,0));
        board_squares[7][7].setPiece(new Rook("w",7,7));
        
        //Knights
        board_squares[0][1].setPiece(new Knight("b",0,1));
        board_squares[0][6].setPiece(new Knight("b",0,6));
        board_squares[7][1].setPiece(new Knight("w",7,1));
        board_squares[7][6].setPiece(new Knight("w",7,6));

        //Bishops
        board_squares[0][2].setPiece(new Bishop("b",0,2));
        board_squares[0][5].setPiece(new Bishop("b",0,5));
        board_squares[7][2].setPiece(new Bishop("w",7,2));
        board_squares[7][5].setPiece(new Bishop("w",7,5));

        //Queens
        board_squares[0][3].setPiece(new Queen("b",0,3));
        board_squares[7][3].setPiece(new Queen("w",7,3));
        
        //Kings
        board_squares[0][4].setPiece(new King("b",0,4));
        board_squares[7][4].setPiece(new King("w",7,4));        
        changeBoard(); // add changes to board to start game
    }

    /**
    * @param a is the thing that triggered the action performed method.
    */
    public void actionPerformed(ActionEvent a)      //Method for when a white square is clicked 
    {
        Square clicked_square = findSquare((JButton) a.getSource());

        //if clicked empty sqr and we dont have selected any piece; return
        if(clicked_square.getPiece() == null && selected_piece == null) return;
        try{System.out.println(clicked_square.getPiece() +  "!= null && " + turnPlayer + " == " + clicked_square.getPiece().color +" && " + selected_piece +" == null" );
        }catch(Exception e){}
        //if clicked piece which is turn players
        if(clicked_square.getPiece() != null && turnPlayer == clicked_square.getPiece().color && selected_piece == null) 
        {
            selected_piece = clicked_square;
            highlightLegalMoves();
            return;
        }
        if(selected_piece != null && legalSquare(clicked_square)) //second click to move
        {
            System.out.println("we legal");
            movePiece(selected_piece,clicked_square);
            selected_piece = null;
            clicked_square = null;
            turnPlayer *= -1;
            changeBoard();
            return;
        }

        changeBoard();                                               // Update the board
    }

    public Square findSquare(JButton b)
    {
        Square clicked_square = null;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board_squares[i][j].getBox().equals(b))    //Double for loop to find which square was clicked
                {
                    return board_squares[i][j];
                }
            }
        }
        return clicked_square;
    }

    public void highlightLegalMoves()
    {
        for (Position pos : selected_piece.getPiece().getLegalSquares(board_squares)) {
            board_squares[pos.xLocation][pos.yLocation].setColor(Color.YELLOW);
        }
        changeBoard();
    }
    public boolean legalSquare(Square move_square)
    {
        ArrayList<Position> legalMoves = selected_piece.getPiece().getLegalSquares(board_squares);
        return legalMoves.contains(move_square.getPosition());
    }

    public void movePiece(Square selected_piece,Square move_square)
    {
        removeHighlightedMoves();
        move_square.setPiece(selected_piece.getPiece());
        
        selected_piece.getPiece().setPosition(move_square.getPosition());
        selected_piece.setPiece(null);
    }

    public void removeHighlightedMoves()
    {
        for (Position pos : selected_piece.getPiece().getLegalSquares(board_squares)) {
            board_squares[pos.xLocation][pos.yLocation].setColor(board_squares[pos.xLocation][pos.yLocation].getOriginalColor());
        }
        changeBoard();     
    }

    public void changeBoard()
    {  
        field.setVisible(true);           //Set the field visible thus making changes 
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the window is closed terminate the program
    }

    
}