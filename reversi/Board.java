import javax.swing.*;
import java.awt.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Board
{
    //making a new JPanel for the board
    JPanel reversiBoard = new JPanel();
    //declaring current player as String
    String currentPlayer;
    //creating a 2d array of JButtons with bounds of 8 and 8
    private final JButton buttonPos[][] = new JButton[8][8];
    //making a 1d array for the coordinates as String
    private String coordinates[];
    public Board() 
    {
        //initallising current player to "B"
        currentPlayer = "B";
        //making new JFrame for the board
        JFrame frame = new JFrame();
        //adding the jpanel to the frame
        frame.getContentPane().add(reversiBoard);
        //setting the layout as a gridlayout with 8 rows and 8 colums and spacing of 2 between them
        reversiBoard.setLayout(new GridLayout(8,8,2,2));
        //the for loop will make the buttons and add action listeners to each button
        for (int x = 0; x < buttonPos.length; x++)
        {
            for (int y = 0; y < buttonPos[x].length; y++)
            {
                //making a new button 
                buttonPos[x][y] = new JButton();
                //adding the button to the jpanel
                reversiBoard.add(buttonPos[x][y]);
                //adding action listeners to each jbutton
                buttonPos[x][y].addActionListener( al );
                //setting the button location as the name 
                buttonPos[x][y].setName(x+""+y);

            }
        }
        //setting frame size
        frame.setSize(500,500);
        //making the frame visible 
        frame.setVisible(true);
        //setting the four middle buttons w/b according to the spec
        buttonPos[4][3].setText("W");
        buttonPos[3][3].setText("B");
        buttonPos[4][4].setText("B");
        buttonPos[3][4].setText("W");
    }
    //action listener for the buttons 
    ActionListener al = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //using getSource() method to find the button text
                //if the button is b it'll change it to w on click and vice versa
                //if the button is empty or "" it'll change it to the current player which is initiallised to b
                JButton src = (JButton) e.getSource();
                if (src.getText().equals("B"))
                    src.setText("W");
                else if (src.getText().equals("W")) 
                    src.setText("B");
                else if (src.getText().equals("")) 
                    src.setText(currentPlayer);
                //splitting the coordinates into a seperate array
                coordinates = src.getName().split("");
                String x = coordinates[0];
                String y = coordinates[1];
                //converting string to integer
                int xint = Integer.parseInt(x);
                int yint = Integer.parseInt(y);
                check(xint, yint, e);
                //System.out.println(x +" " + y);//testing to find out coordinates 

            }
        };

    public JPanel getPanel(){
        //getting/returning JPanel so it can be used in main reversi class
        return reversiBoard;
    }

    public void check(int xpos, int ypos, ActionEvent e)
    {
        // parsing event so i can use getsource to find surrounding buttons 
        JButton src = (JButton) e.getSource();
        for(int y = ypos - 1; y <= ypos + 1; y++) {
            for(int x = xpos - 1; x <= xpos + 1; x++) {
                if( src.getText().equals("w") ){
                    src.setText("b");
                }
            }
        }

    }

}
//Reference:
//https://gist.github.com/brycethomas/1153193/revisions
//https://stackoverflow.com/questions/17624008/jbutton-array-actionlistener

