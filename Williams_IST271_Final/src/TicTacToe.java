import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.*;
//Jacob Williams
//12/8/2018
//IST Final Tic Tac Toe Game
//This classic Java Program is designed to be a tic tac toe game between two players with eight possible ways to win
//once a player has reached one of those it will output winner with X or O. 


//First most important we must extend JFrame for anything to work
public class TicTacToe extends JFrame{
//To hold our content pane
private Container pane;
//This is to see whose turn it is
private String Player;
//2D array which is going to be the board
private JButton [] [] board;
//signal if there is a winner
private boolean Winner;
//building the menu and menu bars.
private JMenuBar menuBar; private JMenu menu;
//actual menu bar options
private JMenuItem quit; private JMenuItem newGame;
//Assigning the window size
private final int WINDOW_WIDTH=500; private final int WINDOW_HEIGHT=500;
	
	//Constructor 
	public TicTacToe(){
		//to call JFrames default constructor 
		super();
		//getting the getContentpane
		pane=this.getContentPane();
		//Setting layout of content pane
		pane.setLayout(new GridLayout(3,3));
		//setting title 
		setTitle("Tic Tac Toe");
		//set window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//close the window but no the program
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//allows the user to see the GUI
		setVisible(true);
		//Making our players
		Player="X";
		//make the board
		board= new JButton[3][3];
		//when the game first starts we don't need a winner
		Winner=false;
		//getting the initalizeBoard and menu bar constructors
		initalizeBoard();
		initalizeMenuBar();
	
	}
	//Method signatures 
	//Initialize menu Bar
	private void initalizeMenuBar(){
		//new instance of our menuBar
		menuBar=new JMenuBar();
		//making our menu
		menu= new JMenu("Options");
		//new JMenu items
		newGame= new JMenuItem("New Game");
		//adding actionListener so they do something when clicked 
		newGame.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			resetBoard();
	}
		});
		//new JMenu item for quit
		quit=new JMenuItem("Quit");
		//actionListiner
		quit.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//stops the program
				System.exit(0);
		}
	});
		//Adding JMenu items to menu and menu to menu bar 
		//and set Menu bar for this JFrame
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
}
	//When user clicks new game it resets the board
	private void resetBoard(){
		Player="X";
		Winner=false;
		//loop through JButtons to reset board
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				board[i][j].setText("");
			}
		}
	}
	//starts the board
	private void initalizeBoard(){
		//this loop is for instantiating j buttons and adding it to the array
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				//adding a new JButton
				JButton btn=new JButton();
				//adding JButton to board
				//make the font
				btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
				board[i][j]=btn;
				//action Listener so it does something
				btn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//if the player can put their piece there
						if (((JButton)e.getSource()).getText().equals("") &&
						//if there is a winner
						Winner==false){
							//player can put piece there
							btn.setText(Player);
							//calling the Winner 
							Winner();
							whichPlayer();
						}
					}
				});
				//add the button to content pane
				pane.add(btn);
			}
			}
	}
	//Which player moves and then sees who turn it is
	private void whichPlayer(){
		//who is going if the player equals x then it knows next is o
		if(Player.equals("X"))
			Player="O";
		//else player is X after O goes
		else
			Player="X";
	}
	//see who wins
	private void Winner(){
		//if else statments to compare all possible winner and coloums
		//This if else statment all it does it go through the 8 possible ways a player can win
		//across both sides. Down all sides and vertical. 
		if(board[0][0].getText().equals(Player)&& board[1][0].getText().equals(Player)&& board[2][0].getText().equals(Player)){
			JOptionPane.showMessageDialog(null, "Player "+Player+" has won");
			Winner=true;
		}
		else if(board[0][1].getText().equals(Player)&& board[1][1].getText().equals(Player)&& board[2][1].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[0][2].getText().equals(Player)&& board[1][2].getText().equals(Player)&& board[2][2].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[0][0].getText().equals(Player)&& board[0][1].getText().equals(Player)&& board[0][2].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[1][0].getText().equals(Player)&& board[1][1].getText().equals(Player)&& board[1][2].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[2][0].getText().equals(Player)&& board[2][1].getText().equals(Player)&& board[2][2].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[0][0].getText().equals(Player)&& board[1][1].getText().equals(Player)&& board[2][2].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		else if(board[0][2].getText().equals(Player)&& board[1][1].getText().equals(Player)&& board[2][0].getText().equals(Player)){
			JOptionPane.showMessageDialog(null,"Player "+Player+" has won");
			Winner=true;
		}
		
	}

	


//the main class
	public static void main(String[] args) {
		//swing Utilities makes it to where our menu will show up right away and not after we click
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				//new tictactoe simulator 
				new TicTacToe();
				
			}

	});

	}
}
