import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;



public class Game {
	//MarvinImagePlugin 
	
	boolean attacked = false;
	
	JFrame window;
	Container con;
	//Panel
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, 
	charBackground, choiceButtonPanel, playerPanel;
	//For the text
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Helvetica", Font.PLAIN, 90);
	Font normalFont = new Font("Verdana", Font.PLAIN, 25);
	
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	
	//var
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) throws IOException{

		new Game();
		 

	}
	
	public Game() {
		//Initialize jframe
		window = new JFrame();
		//Set width, height of window
		window.setSize(800, 600);
		//You can close the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set the color of the window
		window.getContentPane().setBackground(Color.black);
		//Disabled default layout
		window.setLayout(null);
		//Window is visible
		window.setVisible(true);
		
		con = window.getContentPane();
		
		//Panel for the title, sets boundaries and bg color
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		
		//Text for the panel
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		//Panel for the start button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		//Text for the button
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		//Adds the title to the panel
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		//Makes the title and button visible
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		

		window.setVisible(true);

	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		titleNameLabel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		//Customized layout making horizontal buttons
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		//charBackground = new JPanel();
		//charBackground.setBackground(Color.white);
		//charBackground.setBounds(100, 100, 500, 500);
		//con.add(charBackground);
		
		ImageIcon girl = new ImageIcon("Images/neutral2.png");
		JLabel girlLabel = new JLabel();
		girlLabel.setIcon(girl);
		
		//girlLabel.setPreferredSize(new Dimension(100, 100));
		girlLabel.setBounds(50, 50, 800, 800);
		girlLabel.setVisible(true);
		
		con.add(girlLabel);
		
		playerSetup();

		
	}
	
	//Variables for player
	
	public void playerSetup() {
		playerHP = 15;
		monsterHP = 20;
		
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	//Function for the button to work
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
			
		}
	}
	
	//Events
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is in front of you-what do you do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		if(attacked) {
			mainTextArea.setText("Guard: Leave you attacker!");
		}
		else {
			mainTextArea.setText("Guard: Hello stranger. \nI never seen your face before. \nI'm sorry but we can't let a stranger enter our town.");
		}

		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		if(playerHP < 3) {
			mainTextArea.setText("You should have died but through the power of might you're still alive...\nHe's still hitting you.");
		}
		else {
			attacked = true;
			mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You received 3 damage)");
		}


		playerHP = playerHP - 3;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n(HP +2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText("" + playerHP);
		
		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east() {
		position = "east";
		mainTextArea.setText("You walked into a forest and found \na Long Sword!\n\n(You obtained a Long Sword)");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void west() {
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP +"\n\nWhat do you do?");
		
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(4);
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText("" + playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void win() {
		position = "win";
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lose() {
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\nGAME OVER");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void ending() {
		position = "ending";
		
		mainTextArea.setText("Guard: You killed that goblin?\nThank you so much! A true hero!\nWelcome to our town!\n\nTHE END");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//Button actions
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1": 
					if(silverRing == 1) {
						ending();
					}
					else {
						talkGuard(); 
					}
					break;
				case "c2": 
					if(playerHP < 1) {
						lose();
					}
					else {
						attackGuard();
					}
					break;
				case "c3": crossRoad(); break;
				case "c4": break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break;
				case "c4": west(); break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c1": 
					if(monsterHP < 1) {
						win();
					}
					else {
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c1": 
					if(playerHP < 1) {
						lose();
					}
					else {
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
			}
		}
	}
}
