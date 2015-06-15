package projectElements;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToeGUI {

	private JFrame frame;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	private JLabel turnLabel;
	private TicTacToe grid;
	private int buttonsPressed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI window = new TicTacToeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeGUI() {
		buttonsPressed = 0;
		grid = new TicTacToe();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 282, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//VERY IMPORTANT ELIMINATES DEFAULT BORDER LAYOUT
		frame.getContentPane().setLayout(null); 

		JLabel TTTLabel = new JLabel("Tic-Tac-Toe");
		TTTLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		TTTLabel.setBounds(76, 11, 153, 14);
		frame.getContentPane().add(TTTLabel);

		btnOne = new JButton(grid.getGrid(0, 2).toString());
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(0, 2, e);//BUTTON CODE
			}
		});
		btnOne.setBounds(27, 36, 50, 50);
		frame.getContentPane().add(btnOne);

		btnTwo = new JButton(grid.getGrid(1, 2).toString());
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(1, 2, e);//BUTTON CODE
			}
		});
		btnTwo.setBounds(109, 36, 50, 50);
		frame.getContentPane().add(btnTwo);

		btnThree = new JButton(grid.getGrid(2, 2).toString());
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(2, 2, e);//BUTTON CODE
			}
		});
		btnThree.setBounds(192, 36, 50, 50);
		frame.getContentPane().add(btnThree);

		btnFour = new JButton(grid.getGrid(0, 1).toString());
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(0, 1, e);//BUTTON CODE
			}
		});
		btnFour.setBounds(27, 97, 50, 50);
		frame.getContentPane().add(btnFour);

		btnFive = new JButton(grid.getGrid(1, 1).toString());
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(1, 1, e);//BUTTON CODE
			}
		});
		btnFive.setBounds(109, 97, 50, 50);
		frame.getContentPane().add(btnFive);

		btnSix = new JButton(grid.getGrid(2, 1).toString());
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(2, 1, e);//BUTTON CODE
			}
		});
		btnSix.setBounds(192, 97, 50, 50);
		frame.getContentPane().add(btnSix);

		btnSeven = new JButton(grid.getGrid(0, 0).toString());
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(0, 0, e);//BUTTON CODE
			}
		});
		btnSeven.setBounds(27, 158, 50, 50);
		frame.getContentPane().add(btnSeven);

		btnEight = new JButton(grid.getGrid(1, 0).toString());
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				whatButtonsDo(1, 0, e);//BUTTON CODE
			}
		});
		btnEight.setBounds(109, 158, 50, 50);
		frame.getContentPane().add(btnEight);

		btnNine = new JButton(grid.getGrid(2, 0).toString());
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				whatButtonsDo(2, 0, e); //BUTTON CODE
			}
		});
		btnNine.setBounds(192, 158, 50, 50);
		frame.getContentPane().add(btnNine);

		turnLabel = new JLabel("Current Turn: x");
		turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		turnLabel.setBounds(27, 219, 176, 14);
		frame.getContentPane().add(turnLabel);
	}
	
	//One method to do what all the buttons do
	private void whatButtonsDo(int row, int col, ActionEvent e) {
		
		
		//Makes the text display winner if tic-tac-toe
		if (grid.checkLines()) {
			turnLabel.setText("The winner is " + grid.getWhoseTurn());
		}
		else if (buttonsPressed >= 9 && !grid.checkLines()) {
			turnLabel.setText("Draw");
			
		}
		else {
			//Sets grid piece
			if (grid.setPermGrid(row, col)) {
				grid.changeWhoseTurn();
				buttonsPressed++; //Increases number of buttons pressed
			}
			
			((JButton) e.getSource()). //Changes text
						setText(grid.getGrid(row, col).toString());
			
			//Changes color of text
			if (grid.getGrid(row, col).toString().equals("x ")) {
				((JButton) e.getSource()).setForeground(Color.BLUE);
			}
			else if (grid.getGrid(row, col).toString().equals("o ")) {
				((JButton) e.getSource()).setForeground(Color.RED);
			}
			
			//CHecking if game over
			if (grid.checkLines()) {
				//Changes text if tic-tac-toe
				turnLabel.setText("The winner is " + grid.getWhoseTurn());
			}
			//Checks if all buttons presed
			else if (buttonsPressed >= 9 && !grid.checkLines()) {
				turnLabel.setText("Draw");
			}
			//Otherwise continues
			else {
				//Changes text to next turn
				turnLabel.setText("Current Turn: " + grid.getWhoseTurn());
			}
		}
	}
}
