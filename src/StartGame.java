 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.util.ArrayList;
 
 public class StartGame extends JFrame implements ActionListener {
     ImageIcon start = new ImageIcon("resources/images/Start.png"); //Images for the starting screen
     Image img1 = start.getImage();
     Image newimg1 = img1.getScaledInstance(1300, 700, java.awt.Image.SCALE_SMOOTH);
     ImageIcon start1 = new ImageIcon(newimg1);
     JLabel startlbl = new JLabel(start1);
 
     ImageIcon rules = new ImageIcon("resources/images/s.PNG"); //Images for the rule
     Image img2 = rules.getImage();
     Image newimg2 = img2.getScaledInstance(1250, 750, java.awt.Image.SCALE_SMOOTH);
     ImageIcon rules2 = new ImageIcon(newimg2);
     JLabel ruleslbl = new JLabel(rules2);
     ArrayList<JButton> btnList; //Setting up an array list for buttons
 
     /*
      * Purpose: Constructor (Made to print the images and buttons)
      * Pre: N/A
      * Post: N/A
      */
     public StartGame() {
         super("Start");
         setSize(1265, 730);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         String storeMusic = "resources/music/BattleTheme.wav";
         FightingMusic.MenuTheme(storeMusic);
         btnList = new ArrayList<JButton>(); // ArrayList for it to hold buttons
 
         JButton btn1 = new JButton("START"); // Initializing buttons
         JButton btn2 = new JButton("CHOOSE YOUR CHARACTER");
 
         btnList.add(btn1); // Storing the buttons to the ArrayList
         btnList.add(btn2);
 
         for (JButton btn : btnList) { // Setting actionlistener for both buttons by using for loop
             btn.addActionListener(this);
             add(btn);
         }
 
         btn1.setBounds(915, 180, 170, 50); // Coordinates of button
         btn2.setBounds(800, 210, 220, 50);
 
         startlbl.setBounds(0, 0, 1250, 705);
         ruleslbl.setBounds(0, 0, 1249, 750);
         ruleslbl.setVisible(false); // Set the rules and button correlating it to false
         btn2.setVisible(false);
 
         add(startlbl);
         add(ruleslbl);
         setVisible(true);
     }
 
     /*
      * Purpose: When user presses a button an action will occur showing more options to the user. After that the menu class is called
      * Pre: One parameter ActionEvent event
      * Post: N/A
      */
     public void actionPerformed(ActionEvent event) {
         String eventName = event.getActionCommand();
         if (eventName.equals("START")) { // The start section will show setting start and button related to false
             ruleslbl.setVisible(true);
             startlbl.setVisible(false);
             for (JButton btn : btnList) { 
                 if (!btn.getText().equals("START")) { //If the button is clicked or not START 
                     btn.setVisible(true);
                 } else { 
                     btn.setVisible(false);
                 }
             }
         }
         if (eventName.equals("CHOOSE YOUR CHARACTER")) { // The menu will be shown for users so that they can pick characters
             ruleslbl.setVisible(false); // Makes the rules section to false and the menu will be shown
             startlbl.setVisible(false);
             for (JButton btn : btnList) {
                 btn.setVisible(true);
             }
             Menu menu = new Menu(); // Class called
         }
     }
 
     /*
      * Purpose: It is the main method that is used to execute the code
      * pre: N/A
      * post: N/A
      */
     public static void main(String[] args) {
         StartGame Game = new StartGame();
     }
 }
 