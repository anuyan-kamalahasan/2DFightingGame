 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 
 class Menu extends JFrame implements ActionListener {
     static String pickChar1 = "";
     static String pickChar2 = "";
     IPanel pnl = new IPanel();
     ImageIcon gojo = new ImageIcon("resources/images/GojoStanceR.png");
     Image img1 = gojo.getImage();
     // scaled image to fit 200x200
     Image newimg1 = img1.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon gojopic1 = new ImageIcon(newimg1);
     JLabel gojolbl = new JLabel(gojopic1);
 
     // images for itachi
     ImageIcon itachi = new ImageIcon("resources/images/ItachiStanceR .png");
     Image img2 = itachi.getImage();
     // scaled image to fit 200x200
     Image newimg2 = img2.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon itachipic1 = new ImageIcon(newimg2);
     JLabel itachilbl = new JLabel(itachipic1);
 
     // images for kakashi
     ImageIcon kakashi = new ImageIcon("resources/images/KakashiAttack1StartR.png");
     Image img3 = kakashi.getImage();
     // scaled image to fit 200x200
     Image newimg3 = img3.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon kakashipic1 = new ImageIcon(newimg3);
     JLabel kakashilbl = new JLabel(kakashipic1);
 
     // images for zenzitsu
     ImageIcon zenzitsu = new ImageIcon("resources/images/ZenzitsuStanceR.png");
     Image img4 = zenzitsu.getImage();
     // scaled image to fit 200x200
     Image newimg4 = img4.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon zenzitsupic1 = new ImageIcon(newimg4);
     JLabel zenzitsulbl = new JLabel(zenzitsupic1);
 
     // images for ichigo
     ImageIcon ichigo = new ImageIcon("resources/images/IchigoStanceR.png");
     Image img5 = ichigo.getImage();
     // scaled image to fit 200x200
     Image newimg5 = img5.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon ichigopic1 = new ImageIcon(newimg5);
     JLabel ichigolbl = new JLabel(ichigopic1);
 
     // images for sasuke
     ImageIcon sasuke = new ImageIcon("resources/images/SasukeStanceR .png");
     Image img6 = sasuke.getImage();
     // scaled image to fit 200x200
     Image newimg6 = img6.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
     ImageIcon sasukepic1 = new ImageIcon(newimg6);
     JLabel sasukelbl = new JLabel(sasukepic1);
 
     ImageIcon menu = new ImageIcon("resources/images/choose.png");
     Image img7 = menu.getImage();
     // scaled image to fit 200x200
     Image newimg7 = img7.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
     ImageIcon menupic1 = new ImageIcon(newimg7);
     JLabel menu1b1 = new JLabel(menupic1);
 
     // Creating six buttons for names and character for two players each
     JButton btn1 = new JButton("SATORU GOJO");
     JButton btn2 = new JButton("ITACHI UCHIHA");
     JButton btn3 = new JButton("ZENZITSU");
     JButton btn4 = new JButton("KAKASHI HATAKE");
     JButton btn5 = new JButton("ICHIGO KUROSAKI");
     JButton btn6 = new JButton("SASUKE UCHIHA");
     ButtonGroup character = new ButtonGroup();
     JButton btn7 = new JButton("SATORU GOJO");
     JButton btn8 = new JButton("ITACHI UCHIHA");
     JButton btn9 = new JButton("ZENZITSU");
     JButton btn10 = new JButton("KAKASHI HATAKE");
     JButton btn11 = new JButton("ICHIGO KUROSAKI");
     JButton btn12 = new JButton("SASUKE UCHIHA");
     ButtonGroup character2 = new ButtonGroup();
     JButton proceedbtn = new JButton("PROCEED");
 
     // Button to see if the players have locked in the character
     JButton chk2 = new JButton("LOCK CHARACTER PLAYER 1");
     JButton chk1 = new JButton("LOCK CHARACTER PLAYER 2");
     JTextArea txtArea1 = new JTextArea(5, 38);
     JTextArea txtArea2 = new JTextArea(5, 38);
 
     /*
      * Purpose: Constructor (Made to print the images and buttons)
      *  Pre: N/A 
      *  Post: N/A
      */
 
     public Menu() {
         super("Menu");
         setSize(1250, 775); // Size of the output frame
         IPanel pnl = new IPanel();
         pnl.setLayout(null);
         pnl.setBounds(0, 0, 500, 250);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         btn1.addActionListener(this);
         btn2.addActionListener(this);
         btn3.addActionListener(this);
         btn4.addActionListener(this);
         btn5.addActionListener(this);
         btn6.addActionListener(this);
         btn7.addActionListener(this);
         btn8.addActionListener(this);
         btn9.addActionListener(this);
         btn10.addActionListener(this);
         btn11.addActionListener(this);
         btn12.addActionListener(this);
         chk2.addActionListener(this);
         chk1.addActionListener(this);
         character.add(chk2);
         character.add(btn1);
         character.add(btn2);
         character.add(btn3);
         character.add(btn4);
         character.add(btn5);
         character.add(btn6);
         character2.add(btn7);
         character2.add(btn8);
         character2.add(btn9);
         character2.add(btn10);
         character2.add(btn11);
         character2.add(btn12);
         character2.add(chk1);
 
         proceedbtn.addActionListener(this);
         character.add(proceedbtn);
 
         // adds options to the panel and sets the sizes and positions for btniobuttons,
         // text areas, checkboxes, combo boxes, and images
         // To set background color
         pnl.add(btn1);
         btn1.setBounds(60, 450, 140, 30);
         pnl.add(btn2);
         btn2.setBounds(260, 450, 140, 30);
         pnl.add(btn3);
         btn3.setBounds(460, 450, 140, 30);
         pnl.add(btn4);
         btn4.setBounds(660, 450, 140, 30);
         pnl.add(btn5);
         btn5.setBounds(1060, 450, 140, 30);
         pnl.add(btn6);
         btn6.setBounds(860, 450, 140, 30);
         pnl.add(btn7);
         btn7.setBounds(60, 550, 140, 30);
         pnl.add(btn8);
         btn8.setBounds(260, 550, 140, 30);
         pnl.add(btn9);
         btn9.setBounds(460, 550, 140, 30);
         pnl.add(btn10);
         btn10.setBounds(660, 550, 140, 30);
         pnl.add(btn11);
         btn11.setBounds(1060, 550, 140, 30);
         pnl.add(btn12);
         btn12.setBounds(860, 550, 145, 30);
         pnl.add(chk2);
         chk2.setBounds(250, 500, 200, 30);
         pnl.add(chk1);
         chk1.setBounds(250, 600, 200, 30);
         pnl.add(proceedbtn);
         proceedbtn.setBounds(1100, 650, 125, 30);
         gojolbl.setBounds(20, 250, 200, 200);
         itachilbl.setBounds(220, 250, 200, 200);
         zenzitsulbl.setBounds(420, 250, 200, 200);
         kakashilbl.setBounds(620, 250, 200, 200);
         ichigolbl.setBounds(1020, 250, 200, 200);
         sasukelbl.setBounds(820, 250, 200, 200);
         menu1b1.setBounds(375, 0, 500, 120);
         pnl.add(txtArea1);
         txtArea1.setBounds(460, 505, 410, 20);
         pnl.add(txtArea2);
         txtArea2.setBounds(460, 605, 410, 20);
         pnl.add(gojolbl);
         pnl.add(itachilbl);
         pnl.add(zenzitsulbl);
         pnl.add(kakashilbl);
         pnl.add(ichigolbl);
         pnl.add(sasukelbl);
         pnl.add(menu1b1);
         add(pnl);
         setVisible(true); // Set this to be visible (True)
 
     }
 
     /*
      * Purpose: When user presses a button a character will be chosen but the
      * players cannot pick the same one. After battle class is called
      *  Pre: One
      * Parameter ActionEvent event
      *  Post: N/A
      */
 
     public void actionPerformed(ActionEvent event) {
         // if the a certain button is pressed a specific character is picked. Note that
         // both players cannot have the same character
         if (event.getSource() == btn1 && pickChar2 != "SATORU GOJO") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN SATORU GOJO THE SORCOERUR!");
             pickChar1 = "SATORU GOJO";
 
         } else if (event.getSource() == btn2 && pickChar2 != "ITACHI UCHIHA") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN ITACHI UCHIHA THE ROGUE NINJA!");
             pickChar1 = "ITACHI UCHIHA";
 
         } else if (event.getSource() == btn3 && pickChar2 != "ZE`NZITSU") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN ZENZITSU THE LIGHTING DEMON SLAYER!");
             pickChar1 = "ZENZITSU";
 
         } else if (event.getSource() == btn4 && pickChar2 != "KAKASHI HATAKE") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN KAKASHI HATAKE THE COPY NINJA!");
             pickChar1 = "KAKASHI HATAKE";
 
         } else if (event.getSource() == btn5 && pickChar2 != "ICHIGO KUROSAKI") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN ICHIGO KUROSAKI THE SOUL REAPER!");
             pickChar1 = "ICHIGO KUROSAKI";
         } else if (event.getSource() == btn6 && pickChar2 != "SASUKE UCHIHA") {
             txtArea1.setText("PLAYER ONE HAS CHOSEN SASUKE UCHIHA THE LEAF NINJA!");
             pickChar1 = "SASUKE UCHIHA";
         } else if (event.getSource() == chk2) {
             if (pickChar1 == "") {
                 txtArea1.setText("PLAYER ONE REQUEST IS INVALID"); // Check if the player has locked
             } else {
                 txtArea1.setText("PLAYER ONE HAS LOCKED IN " + pickChar1);
                 btn1.setEnabled(false); // Used from source and referenced
                 btn2.setEnabled(false);
                 btn3.setEnabled(false);
                 btn4.setEnabled(false);
                 btn5.setEnabled(false);
                 btn6.setEnabled(false);
             }
         }
         // if the a certain button is pressed a specific character is picked. Note that
         // both players cannot have the same character
         else if (event.getSource() == btn7 && pickChar1 != "SATORU GOJO") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN SATORU GOJO THE SORCOERUR!");
             pickChar2 = "SATORU GOJO";
 
         } else if (event.getSource() == btn8 && pickChar1 != "ITACHI UCHIHA") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN ITACHI UCHIHA THE ROGUE NINJA!");
             pickChar2 = "ITACHI UCHIHA";
 
         } else if (event.getSource() == btn9 && pickChar1 != "ZENZITSU") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN ZENZITSU THE LIGHTING DEMON SLAYER!");
             pickChar2 = "ZENZITSU";
 
         } else if (event.getSource() == btn10 && pickChar1 != "KAKASHI HATAKE") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN KAKASHI HATAKE THE COPY NINJA!");
             pickChar2 = "KAKASHI HATAKE";
 
         } else if (event.getSource() == btn11 && pickChar1 != "ICHIGO KUROSAKI") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN ICHIGO KUROSAKI THE SOUL REAPER!");
             pickChar2 = "ICHIGO KUROSAKI";
         } else if (event.getSource() == btn12 && pickChar1 != "SASUKE UCHIHA") {
             txtArea2.setText("PLAYER TWO HAS CHOSEN SASUKE UCHIHA THE LEAF NINJA!");
             pickChar2 = "SASUKE UCHIHA";
         }
         if (event.getSource() == chk1) {
             if (pickChar2 == "") {
                 txtArea2.setText("PLAYER TWO REQUEST IS INVALID");
             }
 
             else {
                 txtArea2.setText("PLAYER TWO HAS LOCKED IN " + pickChar2);
                 btn7.setEnabled(false); // Used from source and referenced
                 btn8.setEnabled(false);
                 btn9.setEnabled(false);
                 btn10.setEnabled(false);
                 btn11.setEnabled(false);
                 btn12.setEnabled(false);
             }
 
         }
 
         else if (event.getSource() == proceedbtn) {
             if (pickChar1 == "" || pickChar2 == "") {
                 txtArea1.setText("PLAYER ONE REQUEST IS INVALID");
                 txtArea2.setText("PLAYER TWO REQUEST IS INVALID");
 
             } else {
                 Battle vs = new Battle(); // Class called
             }
         }
     } 
      /* Purpose: It is the main method that is used to execute the code
       * pre: N/A
       * post: N/A
      */
 
     public static void main(String[] args) {
         Menu example = new Menu();
     }
 
     /*
      * Purpose: Will get image from the file and bring it in so it can become image for background 
      * Pre:N/A 
      * Post: N/A (But gives background image)
      */
 
     public class IPanel extends JPanel {
         Image menu;
 
         public IPanel() {
             super();
             Toolkit kit = Toolkit.getDefaultToolkit();
             menu = kit.getImage("resources/images/menu.jpg");
         }
 
         public void paintComponent(Graphics comp) {
             Graphics2D comp2D = (Graphics2D) comp;
             comp2D.drawImage(menu, 0, 0, this);
         }
     }
 }
 