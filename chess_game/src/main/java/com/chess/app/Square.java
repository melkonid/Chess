package com.chess.app;


import java.awt.Color;
import java.awt.Image;


import javax.swing.*;

public class Square
{

    private ImageIcon whiteBox = new ImageIcon("empty.png");   // Again images used in program
    private ImageIcon blackBox= new ImageIcon("empty2.png");
    private ImageIcon red = new ImageIcon("red.png");
    private ImageIcon yellow = new ImageIcon("selected.png");
    private ImageIcon white = new ImageIcon("white.png");

    private JButton box=null;                                 // Button variable initialy set to null
    
    private Position position;
    private Piece piece;
    private static int turn=1;                               // Varible to keep track of turns 
    private Color original_color;

    private Square array[][]=null;                            //Array to keep whats happening in board and manipulate squares
    private static Square array_highlight[]=new Square[2];    // Array to keep in the highlighted moves; maximum 2 since it could have 2 forward, 1 if in y edge or 0 if in top 
    
    /**
    * Square Constructor 
    * @param x is the X Location in the board 
    * @param y is the Y Location in the board
    * @param b is the image that that square must be set
    * @param p is an integer value which stores a value for each piece to know what that square has 
    * @param new_array[][] is an array witch is reference for the one in board class to know what is happening in board
    * A student can be enrolled in many courses.
    */
    public Square(int x,int y,Color c,Piece p,Square new_array[][])
    {
        position = new Position(x, y);
        //Setting the image of the button based on what it should be
        box= new JButton();
        original_color = c;  
        box.setBackground(original_color);
        piece=p;             
        array=new_array;
    }

    public Position getPosition()
    {
        return position;
    }

    /**
   * Gets the piece that this square has 
   * @return this piece
   */
    public Piece getPiece()
    {
        return piece;
    } 

    public Color getColor()
    {
        return box.getBackground();
    }

    /**
   * Gets the button that this square has. Used to add button on board or to see if that triggered the ActionListener
   * @return this button
   */
    public JButton getBox()         // Accesor for box
    {
        return box;
    }

    /**
   * Gets the variable to see whose turn is it 
   * @return gets the turn
   */
    public static int getTurn()     // Accesor for turn
    {
        return turn;
    }

    public void setPiece(Piece p)
    {
        this.piece = p;
        try{
            Image image = piece.getIcon().getImage();
            Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            piece.setIcon(new ImageIcon(newimg));  // transform it back
            box.setIcon(piece.getIcon());
        }
        catch(NullPointerException e)
        {
            box.setIcon(null);
        }

    }

    public void setColor(Color c)
    {
        box.setBackground(c);
    }

    public Color getOriginalColor()
    {
        return original_color;
    }
}     