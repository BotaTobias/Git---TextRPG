package VTP;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, imagePanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	ImageIcon image;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main (String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		window = new JFrame();
		window.setSize(850, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
	    startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
	    startButton = new JButton("START");
		startButton.setBackground(Color.black); 
		startButton.setForeground(Color.white); 
	    startButton.setFont(normalFont); 
	    startButton.addActionListener(tsHandler);
	    startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
		
	}
	
	
	public void createGameScreen()
	{
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 350, 430, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area. This game is certainly going to be great!");
		mainTextArea.setBounds(50, 350, 430, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(500, 350, 250, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		
		playerPanel = new JPanel();
		playerPanel.setBounds(500, 100, 300, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2,2));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.red);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.blue);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		imagePanel = new JPanel();
		imagePanel.setBounds(50, 50, 400, 300);
		imagePanel.setBackground(Color.black);
		imageLabel = new JLabel();
		image = new ImageIcon(".//res//crossroad.png");
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		con.add(imagePanel);
		
		playerSetup();
	    
	}
	
	public void playerSetup()
	{
		playerHP = 15;
		monsterHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		crossRoad();
	}
	
	public void townGate() 
	{
		image = new ImageIcon(".//res//guard.jpg");
		imageLabel.setIcon(image);
		
	    position = "townGate";
	    mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
	    choice1.setText("Talk to the guard");
	    choice2.setText("Attack the guard");
	    choice3.setText("Leave");
	    choice4.setText("");
	}
	
	public void talkGuard() 
	{
	    position = "talkGuard";
	    mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \n I'm sorry but we cannot let a stranger \n enter our town.");
	    choice1.setText(">");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	public void attackGuard()
	{
		image = new ImageIcon(".//res//hit.jpg");
		imageLabel.setIcon(image);
		
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid! \n\n The guard fought back and hit you hard. \n You receive 3 damage");
		playerHP = playerHP - 3;
		hpLabelNumber.setText("" + playerHP);
		
		if(weapon.equals("Spear"))
		{
			mainTextArea.setText("Guard: Hey don't be stupid! \n\n The guard fought back and hit you hard. \n You receive 3 damage and you lose \n your spear.");
			weapon = "Bare hands";
			weaponLabelName.setText(weapon);
		}
		
		choice1.setText(">");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");	
	}
	
	public void crossRoad()
	{
		image = new ImageIcon(".//res//crossroad.jpg");
		imageLabel.setIcon(image);
		
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad. \n Which way will you go?");
		choice1.setText("Go North");
	    choice2.setText("Go East");
	    choice3.setText("Go South");
	    choice4.setText("Go West");
		
	}
	
	private void north()
	{
		
		position = "north";
		mainTextArea.setText("There is a river. \n You drink the water and rest at the riverside. \n\n (Your HP is recovered by 3)");
		if(playerHP < 30)
		{
			image = new ImageIcon(".//res//river.jpg");
			imageLabel.setIcon(image);
		    playerHP = playerHP + 3;
		}
		else
		{
			image = new ImageIcon(".//res//");
			imageLabel.setIcon(image);
			mainTextArea.setText("You've rested enough! Adventure awaits!");
		}
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("Go South");
	    choice2.setText("Go Fishing");
	    choice3.setText("");
	    choice4.setText("");
		
	}
	
	public void east()
	{
	
		
		position = "east";
		
		if(weapon.equals("Knife"))
		{
			image = new ImageIcon(".//res//sword.jpg");
			imageLabel.setIcon(image);
			mainTextArea.setText("You walked into a forest and found a \n Long Sword! \n\n (You obtained a Long Sword!)");
			weapon = "Long Sword";
			weaponLabelName.setText(weapon);
		}
		else if(weapon.equals("Long Sword"))
		{
			image = new ImageIcon(".//res//knife.jpg");
			imageLabel.setIcon(image);
			mainTextArea.setText("You returned to the forest to recover \n your knife! \n\n (You replaced your Long Sword with \n your old knife.)");
			weapon = "Knife";
			weaponLabelName.setText(weapon);
		}
		else if(weapon.equals("Spear"))
		{
			image = new ImageIcon(".//res//knife.jpg");
			imageLabel.setIcon(image);
			mainTextArea.setText("You returned to the forest to recover \n your knife! \n\n (You replaced your Spear with \n your old knife.)");
			weapon = "Knife";
			weaponLabelName.setText(weapon);
		}
		else if(weapon.equals("Bare hands"))
		{
			image = new ImageIcon(".//res//knife.jpg");
			imageLabel.setIcon(image);
			mainTextArea.setText("You returned to the forest to recover \n your knife! \n\n (You recovered your default weapon \n and thus you are no longer unarmed.)");
			weapon = "Knife";
			weaponLabelName.setText(weapon);
		}
		
		choice1.setText("Go West");
	    choice2.setText("Forge spear");
	    choice3.setText("");
	    choice4.setText("");
		
	}
	
	public void west()
	{
		image = new ImageIcon(".//res//monster.jpg");
		imageLabel.setIcon(image);
		
		position = "west";
		mainTextArea.setText("You encounter a Monster!");
		choice1.setText("Fight");
	    choice2.setText("Run");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	public void fight()
	{
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\n What do you do?");
		choice1.setText("Attack");
	    choice2.setText("Run");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	public void playerAttack()
	{
		position = "playerAttack";
		int playerDamage = 0;
		if(weapon.equals("Knife"))
		{
			playerDamage = new java.util.Random().nextInt(5);
		}
		else if(weapon.equals("Long Sword"))
		{
			playerDamage = new java.util.Random().nextInt(10);
		}
		else if(weapon.equals("Spear")) 
		{
			playerDamage = 12;
			weapon = "Bare hands";
			weaponLabelName.setText(weapon);
		}
		else if(weapon.equals("Bare hands"))
		{
			playerDamage = new java.util.Random().nextInt(2);
		}
		
		mainTextArea.setText("You attacked the Monster and gave: \n" + playerDamage + " damage!");
				
		monsterHP = monsterHP - playerDamage;
		choice1.setText(">");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	public void monsterAttack()
	{
		position = "monsterAttack";
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(10);
		mainTextArea.setText("The Monster attacked you and gave: \n" + monsterDamage + " damage!");
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText("" + playerHP);
		choice1.setText(">");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
		
	}
	
	public void win()
	{
		image = new ImageIcon(".//res//ring.jpg");
		imageLabel.setIcon(image);
		
		position = "win";
		mainTextArea.setText("You defeated the Monster! \n The Monster dropped a ring! \n\n (You obtained a Silver Ring)");
        silverRing = 1;
        choice1.setText("Go east");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
		
	}
	
	public void monsterKilled()
	{
		image = new ImageIcon(".//res//");
		imageLabel.setIcon(image);
		
		position = "killed";
		mainTextArea.setText("Your job here is done.");
		choice1.setText("Go east");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	public void lose()
	{
		image = new ImageIcon(".//res//ded.jpg");
		imageLabel.setIcon(image);
		
		position = "lose";
		mainTextArea.setText("You lose! \n\n <GAME OVER!>");
		choice1.setText("");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	    choice1.setVisible(false);
	    choice2.setVisible(false);
	    choice3.setVisible(false);
	    choice4.setVisible(false);
		
	}
	
	public void ending()
	{
		image = new ImageIcon(".//res//win.jpg");
		imageLabel.setIcon(image);
		
		position = "ending";
		mainTextArea.setText("Guard: Oh you killed that Monster?! \n Thank you so much! \n You are a true hero! \n Welcome to our town! \n\n <THE END>");
		choice1.setText("");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	    choice1.setVisible(false);
	    choice2.setVisible(false);
	    choice3.setVisible(false);
	    choice4.setVisible(false);
	}
	
	private void spear()
	{
		image = new ImageIcon(".//res//spear.jpg");
		imageLabel.setIcon(image);
		
		position = "spear";
		mainTextArea.setText("You made a wooden spear! You can now fish in the river. You can also use it as a weapon, but only once: you throw it for maximum damage, but then you are \n unarmed.");
		weapon = "Spear";
		weaponLabelName.setText(weapon);
		choice1.setText("Go West");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
	}
	
	private void fishing()
	{
		
		position = "fish";
		if(weapon.equals("Spear") && playerHP < 50)
		{
			image = new ImageIcon(".//res//fish.jpg");
			imageLabel.setIcon(image);
		    playerHP = playerHP + 5;
		    mainTextArea.setText("You used your spear to catch some fish. You cook the fish and eat it. \n\n (Your HP is recovered by 5)");
		}
		else if(playerHP >= 50)
		{
			image = new ImageIcon("");
			imageLabel.setIcon(image);
			mainTextArea.setText("You're stuffed! You cannot fish \n right now...");
		}
		else if(weapon != "Spear")
		{
			mainTextArea.setText("You need a Spear for this!");
		}
		hpLabelNumber.setText("" + playerHP);
		choice1.setText("Go South");
	    choice2.setText("");
	    choice3.setText("");
	    choice4.setText("");
		
	}
	
	public class TitleScreenHandler implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			createGameScreen();
			
		}
		
	}
	
	
	
	public class ChoiceHandler implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String yourChoice = event.getActionCommand();
			
			switch(position)
			{
			    case "townGate":
			    	switch(yourChoice)
			    	{
			    	    case "c1":
			    	    	if(silverRing==1)
			    	    	{
			    	    		ending();
			    	    	}
			    	    	else
			    	    	{
			    	    		talkGuard();
			    	    	}
			    	        break;
			    	    case "c2": attackGuard(); break;
			    	    case "c3": crossRoad(); break;
			    	}
			    	break;
			    	
			    case "talkGuard":
			    	switch(yourChoice)
			    	{
			    	    case "c1": townGate(); break;
			    	}
			    	break;
			    	
			    case "attackGuard":
			    	switch(yourChoice)
			    	{
			    	    case "c1": 
			    	    	if(playerHP < 1)
		                    {
		                        lose();
		                    }
			    	    	else
			    	    	{
			    	    		townGate(); break;
			    	    	}
			    	}
			    	break;
			    	
			    case "crossRoad":
			    	switch(yourChoice)
			    	{
			    	    case "c1": north(); break;
			    	    case "c2": east(); break;
			    	    case "c3": townGate(); break;
			    	    case "c4": 
			    	    if(silverRing == 0)
			    	    {
			    	        west(); break;
			    	    }
			    	    else
			    	    {
			    	    	monsterKilled(); break;
			    	    }
			    	}
			    	break;
			    	
			    case "north":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	    case "c2": fishing(); break;
			    	}
			    	break;
			    	
			    case "east":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	    case "c2": spear(); break;
			    	}
			    	break;
			    	
			    case "west":
			    	switch(yourChoice)
			    	{
			    	    case "c1": fight(); break;
			    	    case "c2": crossRoad(); break;
			    	}
			    	break;
			    	
			    case "fight":
			    	switch(yourChoice)
			    	{
			    	    case "c1": playerAttack(); break;
			    	    case "c2": crossRoad(); break;
			    	}
			    	break;
			    	
			    case "playerAttack":
			    	switch(yourChoice)
			    	{
			    	    case "c1":
                        if(monsterHP < 1)
                        {
                        	win();
                        }
                        else
                        {
                        	monsterAttack();
                        }
                        break;
			    	}
			    	break;
			    	
			    case "monsterAttack":
			    	switch(yourChoice)
			    	{
			    	    case "c1":
                        if(playerHP < 1)
                        {
                        	lose();
                        }
                        else
                        {
                        	fight();
                        }break;
			    	}
			    	break;
			    	
			    case "win":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	}
			    	break;

			    case "killed":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	}
			    	break;
			    	
			    case "spear":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	}
			    	break;
			    case "fish":
			    	switch(yourChoice)
			    	{
			    	    case "c1": crossRoad(); break;
			    	}
			    	break;
			}
		}
		
	}
	
}

