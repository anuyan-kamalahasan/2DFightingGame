import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class BattlePanel extends JPanel implements Runnable, KeyListener {
	String pick = Menu.pickChar1; // This gets the user's input of the character they picked in the menu class
	String pick2 = Menu.pickChar2; // This gets the user's input of the character they picked in the menu class
	private Toolkit kit; // Storing images and changing the size
	// Used from source and referenced for all the variables below
	private long movement = 0;
	private long movement2 = 0;
	private long attack = 0;
	private long attackP1 = 0;
	private long attackP2 = 0;
	private long attackP3 = 0;
	private long attackP5 = 0;
	private long attackP6 = 0;
	private boolean isLeftPressed; // To see if A has been pressed
	private boolean isRightPressed; // To see if D has been pressed
	private boolean isAtk1Pressed; // To see if Q has been pressed
	private boolean isAtk2Pressed; // To see if E has been pressed
	private boolean isLeft2Pressed; // To see if Left has been pressed
	private boolean isRight2Pressed; // To see if Right has been pressed
	private boolean isAtk3Pressed; // To see if SHIFT has been pressed
	private boolean isAtk4Pressed; // To see if ENTER has been pressed
	private boolean jumpP1; // To see if W has been pressed
	private boolean jumpP2; // To see if SPACE has been pressed
	private final long attack20Cooldown = 2000; // Cooldown between special attacks (2 Seconds)
	private final long attack10Cooldown = 1000; // Cooldown between regular attacks (1 Seconds)
	private final long moveCooldown = 50; // Movement cooldown (0.30 Seconds)

	// Declaring image objects
	Image background; // Background
	Image winner; // Winner
	Image health, health2, player1, player2;
	// player 1
	Image stance; // image objects for player 1
	Image stanceOpp;
	Image left;
	Image right;
	Image jump;
	Image Sprite;
	Image attack1;
	Image attack2;
	Image attackOpp1;
	Image attackOpp2;
	Image knockdown;
	// player 1
	Image stance2; // image objects for player 2
	Image stanceOpp2;
	Image left2;
	Image right2;
	Image jump2;
	Image Sprite2;
	Image attack3;
	Image attack4;
	Image attackOpp3;
	Image attackOpp4;
	Image knockdown2;
	// for player 2
	// declaring variables
	private Thread runner;
	int spriteX = 200, spriteY = 300; // the initial position player 1
	int spriteX2 = 900, spriteY2 = 300; // the initial position player 2
	int VELOCITY = 10; // the velocity or speed of sprite
	int imageWidth = 125; // The width of all sprite images
	int imageHeight = 125; // The height of all sprite images
	static int player1Health = 225; // health value for player 1
	static int player2Health = 225; // health value for player 2

	public BattlePanel() {
		super();
		addKeyListener(this); // listens to the keyboard input
		setFocusable(true); // set the panel to be focusable
		requestFocus(); // request focus on the panel to receive key events
		kit = Toolkit.getDefaultToolkit();
		// Set background image
		background = kit.getImage("battle.jpg"); // Battlefield image
		winner = kit.getImage("Winner.jpg"); // Player 1/2 Wins
		health = kit.getImage("Healthbar.png"); // HealthBar Border
		health2 = kit.getImage("Healthbar.png"); // HealthBar Border
		player1 = kit.getImage("Player1.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // Player Border
		player2 = kit.getImage("Player2.png").getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // Player Border
		// Player 1 
		if (pick == "SATORU GOJO") { // If user picked this character here are the images for him
			left = kit.getImage("GojoWalkLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("GojoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("GojoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("GojoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("GojoWalkLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("GojoJumpR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("GojoAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("GojoAttack2Power.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("GojoAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("GojoAttack2Power.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("GojoDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick == "ITACHI UCHIHA") { // If user picked this character here are the images for him
			left = kit.getImage("ItachiRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("ItachiStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("ItachiStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("ItachiStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("ItachiRunRR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("ItachiJumpAttackR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("ItachiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("ItachiAttack2NextR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("ItachiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("ItachiAttack2NextL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("ItachiDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick == "KAKASHI HATAKE") { // If user picked this character here are the images for him
			left = kit.getImage("KakashiRunRL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("KakashiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("KakashiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("KakashiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("KakashiRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("KakashiJumpR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("KakashiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("KakashiAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("KakashiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("KakashiAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("KakashiDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick == "ZENZITSU") { // If user picked this character here are the images for him
			left = kit.getImage("ZenzitsuRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("ZenzitsuStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("ZenzitsuStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("ZenzitsuStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("ZenzitsuRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("ZenzitsuJumpR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("ZenzitsuAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("ZenzitsuAttack1PowerR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("ZenzitsuAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("ZenzitsuAttack1PowerR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("ZenzitsuDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick == "SASUKE UCHIHA") { // If user picked this character here are the images for him
			left = kit.getImage("SasukeRunRL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("SasukeStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("SasukeStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("SasukeStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("SasukeRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("SasukeJumpR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("SasukeAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("SasukeAttack1PowerR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("SasukeAttack1PowerL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("SasukeAttack2EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("SasukeDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick == "ICHIGO KUROSAKI") { // If user picked this character here are the images for him
			left = kit.getImage("IchigoRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance = kit.getImage("IchigoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite = kit.getImage("IchigoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp = kit.getImage("IchigoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right = kit.getImage("IchigoRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump = kit.getImage("IchigoJumpR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack1 = kit.getImage("IchigoAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack2 = kit.getImage("IchigoAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp1 = kit.getImage("IchigoAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp2 = kit.getImage("IchigoAttack2EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown = kit.getImage("IchigoDownR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		}

		// Player 2
		if (pick2 == "SATORU GOJO") { // If user picked this character here are the images for him
			left2 = kit.getImage("GojoWalkLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("GojoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("GojoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("GojoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("GojoWalkLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("GojoJumpL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("GojoAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("GojoAttack2Power.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("GojoAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("GojoAttack2Power.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("GojoDownL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick2 == "ITACHI UCHIHA") { // If user picked this character here are the images for him
			left2 = kit.getImage("ItachiRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("ItachiStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("ItachiStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("ItachiStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("ItachiRunRR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("ItachiJumpAttackL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("ItachiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("ItachiAttack2NextL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("ItachiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("ItachiAttack2NextR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("ItachiDownL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick2 == "KAKASHI HATAKE") { // If user picked this character here are the images for him
			left2 = kit.getImage("KakashiRunRL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("KakashiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("KakashiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("KakashiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("KakashiRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("KakashiJumpL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("KakashiAttack1StartL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("KakashiAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("KakashiAttack1StartR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("KakashiAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("KakashiDownL.png").getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		} else if (pick2 == "ZENZITSU") { // If user picked this character here are the images for him
			left2 = kit.getImage("ZenzitsuRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("ZenzitsuStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("ZenzitsuStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("ZenzitsuStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("ZenzitsuRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("ZenzitsuJumpL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("ZenzitsuAttack2EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("ZenzitsuAttack1PowerL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("ZenzitsuAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("ZenzitsuAttack1PowerR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("ZenzitsuDownL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick2 == "SASUKE UCHIHA") { // If user picked this character here are the images for him
			left2 = kit.getImage("SasukeRunRL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("SasukeStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("SasukeStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("SasukeStanceR .png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("SasukeRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("SasukeJumpL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("SasukeAttack2EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("SasukeAttack1PowerL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("SasukeAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("SasukeAttack1PowerR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("SasukeDownL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		} else if (pick2 == "ICHIGO KUROSAKI") { // If user picked this character here are the images for him
			left2 = kit.getImage("IchigoRunLL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stance2 = kit.getImage("IchigoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			Sprite2 = kit.getImage("IchigoStanceL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			stanceOpp2 = kit.getImage("IchigoStanceR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			right2 = kit.getImage("IchigoRunLR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			jump2 = kit.getImage("IchigoJumpL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack3 = kit.getImage("IchigoAttack1EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attack4 = kit.getImage("IchigoAttack2EndL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp3 = kit.getImage("IchigoAttack1EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			attackOpp4 = kit.getImage("IchigoAttack2EndR.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
			knockdown2 = kit.getImage("IchigoDownL.png").getScaledInstance(imageWidth, imageHeight,
					java.awt.Image.SCALE_SMOOTH);
		}
		runner = new Thread(this); // New thread named runner
		runner.start(); // Starts the thread
	}

	public void checkCollisionPlayer1() {
		Rectangle player1Bounds = new Rectangle(spriteX, spriteY, imageWidth, imageHeight);
		Rectangle player2Bounds = new Rectangle(spriteX2, spriteY2, imageWidth, imageHeight);

		if (player1Bounds.intersects(player2Bounds)) {
			player2Health -= 10;
		}
	}

	public void checkCollisionPlayer1Pt2() {
		Rectangle player1Bounds = new Rectangle(spriteX, spriteY, imageWidth, imageHeight);
		Rectangle player2Bounds = new Rectangle(spriteX2, spriteY2, imageWidth, imageHeight);

		if (player1Bounds.intersects(player2Bounds)) {
			player2Health -= 20;
		}
	}

	public void checkCollisionPlayer2() {
		Rectangle player1Bounds = new Rectangle(spriteX, spriteY, imageWidth, imageHeight);
		Rectangle player2Bounds = new Rectangle(spriteX2, spriteY2, imageWidth, imageHeight);

		if (player1Bounds.intersects(player2Bounds)) {
			player1Health -= 10;
		}
	}

	public void checkCollisionPlayer2Pt2() {
		Rectangle player1Bounds = new Rectangle(spriteX, spriteY, imageWidth, imageHeight);
		Rectangle player2Bounds = new Rectangle(spriteX2, spriteY2, imageWidth, imageHeight);

		if (player1Bounds.intersects(player2Bounds)) {
			player1Health -= 20;
		}
	}

	public void paintComponent(Graphics comp) {
		super.paintComponent(comp);
		Graphics2D comp2D = (Graphics2D) comp;

		comp2D.drawImage(background, 0, 0, this); // draws background image
		comp2D.drawImage(health, 10, 550, this); // draws health bar
		comp2D.drawImage(health2, 950, 550, this); // draws health bar
		comp2D.drawImage(player1, 65, 535, this); // draws player image
		comp2D.drawImage(player2, 1000, 535, this); // draws player image
		comp2D.drawImage(Sprite, spriteX, spriteY, this); // draws sprite 1
		comp2D.drawImage(Sprite2, spriteX2, spriteY2, this); // draws sprite 2
		// Draw health bars
		comp2D.setColor(Color.RED); // Player 1 health bar color
		comp2D.fillRect(75, 615, player1Health, 35); // Player 1 health bar rectangle
		comp2D.setColor(Color.BLUE); // Player 2 health bar color
		comp2D.fillRect(1015, 615, player2Health, 35); // Player 2 health bar rectangle

	}

	public void run() {
		Thread thisThread = Thread.currentThread(); // Handle player movements and attacks based on the boolean
													// variables
		try {
			Thread.sleep(0); // pause the thread for 20 milliseconds (Fast the images switches)
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		// Used from source and referenced
		while (runner == thisThread) { // This will use a series of if statements along with boolean variables to see

			// if the button has been pressed. If yes then a specific action will occur
			if (player1Health <= 0) {
				Sprite2 = stance2;
				Sprite = knockdown;
				spriteY = 300;
				spriteY2 = 300;
				Winner win = new Winner();
				break;
			}

			// Check if player 2 health is 0 or below
			if (player2Health <= 0) {
				Sprite = stance;
				Sprite2 = knockdown2;
				spriteY = 300;
				spriteY2 = 300;
				Winner win = new Winner();
				break;

			}
			if (isLeftPressed) { // Used from source and referenced
				long time1 = System.currentTimeMillis(); // Stores currentTimeMillis which
				if (time1 - movement >= moveCooldown) {
					Sprite = left; // Image that should output
					if (spriteX > 150) { // This creates a barrier for where the image cannot pass
						spriteX -= VELOCITY; // Speed of the sprite
					} else {

					}
					movement = time1; // Update the last movement

				}
			}

			if (isRightPressed) { // Used from source and referenced
				long time1 = System.currentTimeMillis();
				if (time1 - movement >= moveCooldown) {
					Sprite = right;
					if (spriteX < 1000) {
						spriteX += VELOCITY;
					} else {

					}
					movement = time1; // Update the last attack time

				}

			}

			if (isAtk1Pressed) {// Used from source and referenced
				if (spriteX < spriteX2) {
					long time = System.currentTimeMillis();
					if (time - attack >= attack10Cooldown) {
						Sprite = attack1;
						AttackSoundEffect1 music2 = new AttackSoundEffect1();
						String storeMusic = "Punch.wav";
						AttackSoundEffect1.MenuTheme(storeMusic);
						// Perform attack type 1 for player 1
						checkCollisionPlayer1();
						attack = time; // Update the last attack time
					}
				} else if (spriteX > spriteX2) {
					long time4 = System.currentTimeMillis();
					if (time4 - attackP3 >= attack10Cooldown) {
						Sprite = attackOpp1;
						AttackSoundEffect1 music2 = new AttackSoundEffect1();
						String storeMusic = "Punch.wav";
						AttackSoundEffect1.MenuTheme(storeMusic);
						// Perform attack type 1 for player 1
						checkCollisionPlayer1();
						attackP3 = time4; // Update the last attack time
					}
				}

			}
			if (isAtk2Pressed) { // Used from source and referenced
				if (spriteX < spriteX2) {
					long time3 = System.currentTimeMillis();
					if (time3 - attackP2 >= attack20Cooldown) {
						Sprite = attack2;
						if (spriteX < 1000) {
							spriteX = spriteX + 200; //Dash effect occurs but moving its position 
						} else {

						}
						AttackSoundEffect2 music = new AttackSoundEffect2();
						String storeMusic = "Attack2Effect.wav";
						AttackSoundEffect2.MenuTheme(storeMusic);
						// Perform attack type 2 for player 1
						checkCollisionPlayer1Pt2();
						attackP2 = time3; // Update the last attack time

					}

				} else if (spriteX > spriteX2) {
					long time5 = System.currentTimeMillis();
					if (time5 - attackP2 >= attack20Cooldown) {
						Sprite = attackOpp2;
						if (spriteX > 150) {
							spriteX = spriteX - 200; //Dash effect occurs but moving its position 
						} else {

						}
						AttackSoundEffect2 music = new AttackSoundEffect2();
						String storeMusic = "Attack2Effect.wav";
						AttackSoundEffect2.MenuTheme(storeMusic);
						// Perform attack type 2 for player 1
						checkCollisionPlayer1Pt2();
						attackP2 = time5; // Update the last attack time
					}
				}
			}

			if (isLeft2Pressed) { // Used from source and referenced
				long time6 = System.currentTimeMillis();
				if (time6 - movement2 >= moveCooldown) {
					Sprite2 = left2;
					if (spriteX2 > 150) {
						spriteX2 -= VELOCITY;
					} else {

					}
					movement2 = time6; // Update the last attack time

				}
			}

			if (isRight2Pressed) { // Used from source and referenced
				long time6 = System.currentTimeMillis();
				if (time6 - movement2 >= moveCooldown) {
					Sprite2 = right2;
					if (spriteX2 < 1000) {
						spriteX2 += VELOCITY;
					} else {

					}
					movement2 = time6; // Update the last attack time

				}

			}
			if (isAtk3Pressed) { // Used from source and referenced
				if (spriteX < spriteX2) {
					long time2 = System.currentTimeMillis();
					if (time2 - attackP1 >= attack10Cooldown) {
						// Perform attack type 1 for player 2
						Sprite2 = attack3;
						AttackSoundEffect1 music2 = new AttackSoundEffect1();
						String storeMusic = "Punch.wav";
						AttackSoundEffect1.MenuTheme(storeMusic);
						checkCollisionPlayer2();
						attackP1 = time2; // Update the last attack time
					}
				} else if (spriteX > spriteX2) {
					long time6 = System.currentTimeMillis();
					if (time6 - attackP5 >= attack10Cooldown) {
						// Perform attack type 1 for player 2
						Sprite2 = attackOpp3;
						AttackSoundEffect1 music2 = new AttackSoundEffect1();
						String storeMusic = "Punch.wav";
						AttackSoundEffect1.MenuTheme(storeMusic);
						checkCollisionPlayer2();
						attackP5 = time6; // Update the last attack time
					}

				}

			}
			if (isAtk4Pressed) { // Used from source and referenced
				if (spriteX < spriteX2) {
					long time7 = System.currentTimeMillis();
					if (time7 - attackP6 >= attack20Cooldown) {
						Sprite2 = attack4;
						if (spriteX2 > 150) {
							spriteX2 = spriteX2 - 200; //Dash effect occurs but moving its position 
						} else {

						}

						AttackSoundEffect2 music = new AttackSoundEffect2();
						String storeMusic = "Attack2Effect.wav";
						AttackSoundEffect2.MenuTheme(storeMusic);
						checkCollisionPlayer2Pt2();
						attackP6 = time7; // Update the last attack time
					}
				} else if (spriteX > spriteX2) {
					long time8 = System.currentTimeMillis();
					if (time8 - attackP6 >= attack20Cooldown) {
						Sprite2 = attackOpp4;
						if (spriteX2 < 1000) {
							spriteX2 = spriteX2 + 200; //Dash effect occurs but moving its position 
						} else {

						}

						AttackSoundEffect2 music = new AttackSoundEffect2();
						String storeMusic = "Attack2Effect.wav";
						AttackSoundEffect2.MenuTheme(storeMusic);
						checkCollisionPlayer2Pt2();
						attackP6 = time8; // Update the last attack time
					}
				}

				if (jumpP1) { // Used from source and referenced
					long time1 = System.currentTimeMillis();
					if (time1 - movement >= moveCooldown) {
						Sprite = jump;
						if (spriteX < 1000 || spriteX > 150) {
						} else {

						}
						movement = time1; // Update the last attack time

					}
				}

				if (jumpP2) { // Used from source and referenced
					long time6 = System.currentTimeMillis();
					if (time6 - movement >= moveCooldown) {
						Sprite = jump;
						if (spriteX2 < 1000 || spriteX2 > 150) {
						} else {

						}
						movement = time6; // Update the last attack time

					}
				}

			}

			repaint(); // repaint the panel

		}
	}

	/*
	 * Purpose: Purpose is to output a certain image if boolean is true
	 * Pre: One parameter KeyEvent e
	 *  Post: N/A
	 */
	public void keyPressed(KeyEvent e) { // Used from source and referenced for learning how to use boolean for keyListeners
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			isLeftPressed = true;
		}
		if (key == KeyEvent.VK_D) {
			isRightPressed = true;
		}
		if (key == KeyEvent.VK_Q) {
			isAtk1Pressed = true;
		}
		if (key == KeyEvent.VK_E) {
			isAtk2Pressed = true;
		}

		if (key == KeyEvent.VK_LEFT) {
			isLeft2Pressed = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			isRight2Pressed = true;
		}
		if (key == KeyEvent.VK_SHIFT) {
			isAtk3Pressed = true;
		}
		if (key == KeyEvent.VK_ENTER) {
			isAtk4Pressed = true; 
		}
		if (key == KeyEvent.VK_W) {
			jumpP1 = true;
			if(spriteY==300) {
			spriteY = spriteY - 200; //Jump effect occurs
			}
			else {
				
			}

		}
		if (key == KeyEvent.VK_SPACE) {
			jumpP1 = true;
			if(spriteY2==300) {
			spriteY2 = spriteY2 - 200; //Jump effect occurs
			}
			else {
			}
			}
		}
	

	/*
	 * Purpose: This will output an image if the one of the following buttons is
	 * released Pre: One parameter KeyEvent e Post: N/A
	 */
	public void keyReleased(KeyEvent e) { // Used from source and referenced for learning how to use boolean for
											// keyListeners
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			isLeftPressed = false;
			Sprite = stanceOpp; //Outputs stance image accordingly
		}
		if (key == KeyEvent.VK_D) { 
			isRightPressed = false;
			Sprite = stance; //Outputs stance image accordingly
		}
		if (key == KeyEvent.VK_Q) {
			isAtk1Pressed = false;
			if (spriteX < spriteX2) { //Check the position of the two players and outputs the direction of the player
				Sprite = stance;
			} else if (spriteX > spriteX2) {
				Sprite = stanceOpp; //Outputs stance image accordingly
			}
		}
		if (key == KeyEvent.VK_E) {
			isAtk2Pressed = false;

			if (spriteX < spriteX2) { //Check the position of the two players and outputs the direction of the player
				Sprite = stance;
			} else if (spriteX > spriteX2) {
				Sprite = stanceOpp; //Outputs stance image accordingly
			}
		}
		if (key == KeyEvent.VK_LEFT) {
			isLeft2Pressed = false;
			Sprite2 = stance2; //Outputs stance image accordingly
		}
		if (key == KeyEvent.VK_RIGHT) {
			isRight2Pressed = false;
			Sprite2 = stanceOpp2; //Outputs stance image accordingly
		}
		if (key == KeyEvent.VK_SHIFT) {
			isAtk3Pressed = false;
			if (spriteX < spriteX2) { //Check the position of the two players and outputs the direction of the player
				Sprite2 = stance2;
			} else if (spriteX > spriteX2) {
				Sprite2 = stanceOpp2;
			}
		}
		if (key == KeyEvent.VK_ENTER) {
			isAtk4Pressed = false;
			if (spriteX < spriteX2) { //Check the position of the two players and outputs the direction of the player
				Sprite2 = stance2;
			} else if (spriteX > spriteX2) {
				Sprite2 = stanceOpp2;
			}
		}

		if (key == KeyEvent.VK_W) {
			jumpP1 = false;
			Sprite = stance; //stance form
			spriteY = 300;  //Returns to original Y coor
		}
		if (key == KeyEvent.VK_SPACE) {
			jumpP1 = false; 
			Sprite2 = stance2; //Stance form 
			spriteY2 = 300; //Returns to original Y coor
		}
	}

	/*
	 * Purpose: Serves no purpose but is required for the program to work since
	 * KeyListener is being used Pre: One parameter KeyEvent event Post: N/A
	 */
	public void keyTyped(KeyEvent event) {
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Battle Game");
		BattlePanel panel = new BattlePanel();
		frame.getContentPane().add(panel);
		frame.setSize(1290, 1200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
