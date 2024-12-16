 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
 public class Winner extends JFrame {
     ImageIcon gameOver = new ImageIcon("GameOver.jpg"); //Image for gameover
     Image img1 = gameOver.getImage();
     Image newimg1 = img1.getScaledInstance(1200, 700, java.awt.Image.SCALE_SMOOTH);
     ImageIcon gameOver1 = new ImageIcon(newimg1);
     JLabel gameOverlbl = new JLabel(gameOver1);
     JButton btn1;
     JButton btn2;
      /*
      * Purpose: Constructor (Made to print the image when one of the two players loses)
      * Pre: N/A
      * Post: N/A
      */
     public Winner() {
         super("gameOver");
         setSize(1210, 730);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         gameOverlbl.setBounds(0, 0, 1200, 705);
         add(gameOverlbl);
         setVisible(true); //Sets image to visible when setting the bounds
     }
     
      /* Purpose: It is the main method that is used to execute the code
       * pre: N/A
       * post: N/A
      */
 
     public static void main(String[] args) {
         Winner Game = new Winner();
     }
 }
 