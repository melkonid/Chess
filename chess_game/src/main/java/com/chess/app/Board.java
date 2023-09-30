package com.chess.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.chess.app.Square;

public class Board //implements ActionListener
{
    

    private ImageIcon whiteBox = new ImageIcon("src\\main\\resources\\white_square.png");  // Images used in program
    private ImageIcon blackBox= new ImageIcon("src\\main\\resources\\green_square.png");


    private JFrame field = new JFrame("Chess");      //Title!
    private JPanel panel=new JPanel();                  //Panel to add buttons 
    private GridLayout grid = new GridLayout (8,8);     //Grid layout so the buttons don't strech 


    Square board_squares[][]=new Square[8][8];          //Array to keep up to date with whats happening on board and use some other squares other like the one called method
    Square previous= null;
    Square new_pressed=null;                            // Two square variable to keep track with previous and this square pressed
    
    public Board ()
    {   
        field.setSize(800,800);                         
        field.setContentPane(panel);
        
        panel.setLayout(grid);
       iniateBoard();
        
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
                panel.add(board_squares[i][j].getBox());
                counter++;
            }
        }
        changeBoard(); // add changes to board to start game
    }

    /**
    * @param a is the thing that triggered the action performed method.
    */
    // public void actionPerformed(ActionEvent a)      //Method for when a white square is clicked 
    // {
    //   for(int i=0;i<8;i++)
    //     {
    //         for(int j=0;j<8;j++)
    //         {
    //             if(board_squares[i][j].getBox()==a.getSource())    //Double for loop to find which square was clicked
    //             {
    //                 previous=new_pressed;                          // Previous clicked becomes equal with the new_pressed which has not been updated yet
    //                 new_pressed=board_squares[i][j];               // New_pressed gets the value of the new clicked square
    //                 if(previous==null)                             // In case its the first click
    //                 {
    //                     if(new_pressed.getPiece()==new_pressed.getTurn())  // And the clicked square contains a piece which is equal to that turns 
    //                     {
    //                         new_pressed.highlight();                       // Call method to highlight squares it can go

    //                     }
    //                 }
    //             }
    //         }
    //     }
    //      if(previous!=null && new_pressed!=null && previous!=new_pressed)      //If both squares have a value and they are not equal 
    //      {
    //         boolean canGo=previous.canMoveTo(new_pressed);                     // Get a variable to see if it CAN move there where it was clicked 
    //         previous.clear();                                                  // Clear the previous highlighted no matter if it can go or not
    //         if(canGo)                //If it was a valid move
    //         {
    //             previous.moveTo(new_pressed);       // Call method to move piece
    //             previous=null;                      // Reset values of previous and new_pressed because a move was made
    //             new_pressed=null; 
    //         }
    //         else           //If invalid move 
    //         {
    //             if(new_pressed.getPiece()==new_pressed.getTurn())     // And if the new_pressed square contains a piece which it the one of the turn player
    //             {
    //                 new_pressed.highlight();                          // Highlight the moves of the new piece clicked 
    //             }
    //         }
            
    //      }
    //      changeBoard();                                               // Update the board
    // }

    public void changeBoard()
    {  
        field.setVisible(true);           //Set the field visible thus making changes 
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the window is closed terminate the program
    }
    
}