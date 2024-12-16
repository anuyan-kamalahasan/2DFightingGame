import java.awt.*;
import javax.swing.*;

public class Battle extends JFrame {
	 /*
     * Purpose: Constructor (This creates the battle field based on the BattlePanel class. Creates the frame)
     * Pre: N/A
     * Post: N/A
     */
	public Battle() {
		super("BattleGame");
		setSize(1290, 750);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BattlePanel store = new BattlePanel();
		add(store, BorderLayout.CENTER);
		setVisible(true);
	}
	 /* Purpose: It is the main method that is used to execute the code
	  * pre: N/A
	  * post: N/A
	 */

	public static void main(String[] arguments) {
		Battle frame = new Battle();
	}
}
