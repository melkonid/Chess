package com.chess.app;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class Square
{

    private ImageIcon whiteBox = new ImageIcon("empty.png");   // Again images used in program
    private ImageIcon blackBox= new ImageIcon("empty2.png");
    private ImageIcon red = new ImageIcon("red.png");
    private ImageIcon yellow = new ImageIcon("selected.png");
    private ImageIcon white = new ImageIcon("white.png");

    private JButton box=null;                                 // Button variable initialy set to null
    
    private int xLocation;                                    // Instance varibles for location xLocation,yLocation,piece
    private int yLocation;
    private Piece piece;
    private static int turn=1;                                // Varible to keep track of turns 

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
        xLocation=x;
        yLocation=y;
        box= new JButton();   //Setting the image of the button based on what it should be 
        box.setBackground(c);
        piece=p;               // Red piece =-1  White piece = 1  White box = 0 Black box = -2 and yellow(highlighted)= 3 (although not initialised but the constructor )
        array=new_array;
    }

    /**
   * Gets the xLocation of this square in board 
   * @return this xLocation 
   */
    public int getXLocation()
    {
         return xLocation;           // Accesors for xLocation, yLocation, piece; are not used in the program except getPiece but were really helpful in debugging so I am keeping them
    }                                // In case I want to play around with it in the future ;) 

    /**
   * Gets the yLocation of this square in board 
   * @return this yLocation 
   */
    public int getYLocation()
    { 
        return yLocation;
    }

    /**
   * Gets the piece that this square has 
   * @return this piece
   */
    public Piece getPiece()
    {
        return piece;
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
        Image image = piece.getIcon().getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        piece.setIcon(new ImageIcon(newimg));  // transform it back
        box.setIcon(piece.getIcon());
    }

    /**
    * Method to move piece 
    * @param new_pos is the new_pos that the the previous one (the one called the method ) should go
    */
    // public void moveTo(Square new_pos)      
    // {
    //     if(piece==1 && turn==1)             // If it is that pieces turn
    //     {
    //         (new_pos.box).setIcon(white);   //Set new_pos box icon to white piece 
    //         turn=-1;                        // Change the turn since a move was made
    //         box.setIcon(whiteBox);          // Change the previous position box icon which the function was called on to white box
    //         swapValues(new_pos,array[xLocation][yLocation]); // Call a small method to swap values of what they contain 
    //     }
    //     if(piece==-1 && turn==-1)
    //     {
    //         (new_pos.box).setIcon(red);      // Same with turn=-1 where the icon in new pos needed to be set in red piece instead of white
    //         turn=1;
    //         box.setIcon(whiteBox);
    //         swapValues(new_pos,array[xLocation][yLocation]);
    //     }
    // }
    /**
    * Method to swap piece values after movement
    * @param a is the square it moved to 
    * @param b is the square that it came from 
    */
    // public void swapValues(Square a, Square b)       
    // {
    //     Square temp= new Square(0,0,null,0,null);     // A temporary value
    //     temp.piece=a.piece; 

    //     a.piece=b.piece;        

    //     b.piece=temp.piece;                          // Swap pieces values 
    // }

    /**
    * Highlight method to highlight available moves!
    */
    // public void highlight()                          
    // {
    //     if(xLocation-turn<0 || xLocation-turn>7)    // Check wheather it passes array x limits (xLocation-turn) for white (turn is 1) must be greater or equal than 0 
    //     {                                           // while for red (turn is -1) it must be less than 8 
    //         array_highlight[0]=null;                // If any of them is true --> no moves available 
    //         array_highlight[1]=null;
    //     }
    //     else if(yLocation+1>7)                      // else if it passes y limits 
    //     {
    //         array_highlight[0]=new Square(xLocation-turn,yLocation-1,null,3,null); // Set the other square to available square 
    //         array_highlight[1]=null;
    //     }
    //     else if(yLocation-1<0)                   // Same here but from the other y limit 
    //     {
    //         array_highlight[0]=new Square(xLocation-turn,yLocation+1,null,3,null);
    //         array_highlight[1]=null;
    //     }
    //     else
    //     {
    //         array_highlight[0]=new Square(xLocation-turn,yLocation-1,null,3,null);    // else both squares are available 
    //         array_highlight[1]=new Square(xLocation-turn,yLocation+1,null,3,null);   
    //     }
    //     for(int i=0;i<2;i++)
    //     {
    //         if(array_highlight[i]!=null)    // Highlighting squares which are not null and setting their 'piece' value to 3--> highlighted
    //         {
    //             int posx=array_highlight[i].xLocation;
    //             int posy=array_highlight[i].yLocation;
    //             if(array[posx][posy].piece==0)  // If and only if the square is a white empty box 
    //             {
    //                 (array[posx][posy].box).setIcon(yellow);
    //                 array[posx][posy].piece=3;  
    //             }
    //         }
    //     }
    // }

    // /**
    // * Clear method to clear previously highlighed moves 
    // */
    // public void clear()                
    // {
    //     for(int i=0;i<2;i++)
    //     {   if(array_highlight[i]!=null)    // If the array contains anything that is not null which means a highlighted square 
    //         {
    //             int posx=array_highlight[i].xLocation;
    //             int posy=array_highlight[i].yLocation;
    //             if(array[posx][posy].piece==3)   // and if the value is still 3 (the piece did not move there)
    //             {
    //                 (array[posx][posy].box).setIcon(whiteBox);
    //                 array[posx][posy].piece=0;     // Set it to white box and change its 'piece' value to 0
    //             }
    //         }
    //     }
    // }

    // /**
    // * Function to see if the piece CAN go to that square
    // * @return retuns true of false wheather it can move there or not
    // */
    // public boolean canMoveTo(Square new_pos)     
    // {  
    //     if(new_pos.piece==3)                     // If is is highlighted it means it can go there
    //     {
    //         return true;                         // Return a true in this case else false
    //     }
    //     return false;
    // }
}     