import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reversi
{
    //decalaring player textfields
    JTextField PlayerOne = new JTextField();
    JTextField PlayerTwo = new JTextField();
    // decalaring jlabels 
    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    //decalaring playernames as string 
    String player1name=PlayerOne.getText();
    String player2name=PlayerTwo.getText();
    /**
     * Constructor for objects of class Reversi
     */
    public Reversi()
    {
        //calling method
        makeFrame();
    }

    private void makeFrame()
    {
        //making new jframe 
        JFrame frame = new JFrame();
        //setting layout as borderlayout
        frame.setLayout(new BorderLayout());
        //setting layout as borderlayout
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new BorderLayout());
        //adding the panels to the frame and positioning them 
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.getContentPane().add(panel1, BorderLayout.CENTER);
        // making a new menubar
        JMenuBar menuBar = new JMenuBar();
        //adding new jmenu items 
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem saveGame = new JMenuItem("Save Game");
        JMenuItem exitGame = new JMenuItem("Close Game");
        menuBar.add(file);
        //adding sub-menu items to the file option
        file.add(newGame);
        file.addSeparator();
        file.add(saveGame);
        file.addSeparator();
        file.add(exitGame);
        //adding new jmenu for the game size
        JMenu gameSize = new JMenu("GameSize");
        JMenuItem x6 = new JMenuItem("6X6");
        JMenuItem x8 = new JMenuItem("8X8");
        JMenuItem x10 = new JMenuItem("10X10");
        //adding the gamesize to the menu bar
        menuBar.add(gameSize);
        gameSize.add(x6);
        gameSize.add(x8);
        gameSize.add(x10);

        //coding for the close option on the jmenu 
        exitGame.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }

            });
        //coding for the new game option on the jmenu 
        newGame.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    makeFrame();
                }

            });
        //coding for 6x6 game size option on the jmenu 
        x6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }

            });
        //coding for 8x8 game size option on the jmenu 
        x8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }

            });
        //coding for 10x10 game size option on the jmenu
        x10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }

            });

        //adding the player panel and positioning it east(right)
        frame.add(makePlayerPanel(), BorderLayout.EAST);

        //casting the board class 
        Board b = new Board();
        //new label for istructions
        JLabel start = new JLabel("Please Enter Your Name and Press Play                     ");

        //adding components to the panel and positioning them
        panel.add(start, BorderLayout.WEST);
        panel.add(player1, BorderLayout.CENTER);
        panel.add(player2, BorderLayout.EAST);

        //adding the board from the board class and putting it in the center
        frame.getContentPane().add(b.getPanel(), BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);
        //setting frame size
        frame.setSize(new Dimension(750, 600));
        //setting start position
        frame.setLocationRelativeTo(null);
        //set default close action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set a title
        frame.setTitle("Reversi");
        //Disable resize
        frame.setResizable(true);
        //frame.setDefault
        frame.setVisible(true);
    }

    public JPanel makePlayerPanel()
    {
        //making a new frame
        JFrame playerPanelFrame = new JFrame();
        //setting frame layout
        playerPanelFrame.setLayout(new BorderLayout());
        //setting the jpanel layout as gridlayout
        JPanel scoreBoard = new JPanel(new GridLayout(5,4,3,3));
        //adding the jpanel to the jframe
        playerPanelFrame.getContentPane().add(scoreBoard);
        //making the player labels to make it clear what to do 
        JLabel p1 = new JLabel("Enter Player ONE Name: ");
        JLabel p2 = new JLabel("Enter Player TWO Name: ");
        //making a jbutton 
        JButton play = new JButton("Play");
        //making playerscore labels
        JLabel p1score = new JLabel("Player ONE Score: ");
        JLabel p2score = new JLabel("Player TWO Score: ");
        //making jlabels to represent player scores
        JLabel p1Changingscore = new JLabel("0");
        JLabel p2Changingscore = new JLabel("0");
        //adding actionlistener to the play button
        play.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //making sure the players names are not editable once play is pressed
                    PlayerOne.setEditable(false);
                    PlayerTwo.setEditable(false);
                    player1.setText("                       Player: "+player1name);
                    player2.setText("Player: "+player2name);
                    player1.setVisible(true);
                    player2.setVisible(true);
                }
            });

        PlayerTwo.setSize(new Dimension(200, 40));
        PlayerOne.setSize(new Dimension(200, 40));

        //adding components to the jpanel
        scoreBoard.add(p1);   
        scoreBoard.add(PlayerOne);
        scoreBoard.add(p2);
        scoreBoard.add(PlayerTwo);
        scoreBoard.add(p1score);
        scoreBoard.add(p2score);
        scoreBoard.add(p1Changingscore);
        scoreBoard.add(p2Changingscore);
        scoreBoard.add(play);
        scoreBoard.setVisible(true);

        return scoreBoard;
    }

}
