import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Random;

class gamePanel extends JPanel implements ActionListener {
  final int screenWidth = 600;
  final int screenHeight = 600;

  // Unit size of the snake and the food that it can eat.
  final int unitSize = 25;
  // Used to see how many objects we can fit onto the screen.
  final int gameUnits = (screenWidth * screenHeight) / unitSize;
  final int delay = 75;

  // The reason that we create an empty pre-defined
  final int[] snakeArrayX = new int[gameUnits];
  final int[] snakeArrayY = new int[gameUnits];
  int bodyParts = 6;

  int foodEaten = 0;
  int foodX;
  int foodY;

  char direction = 'R';
  boolean running = false;

  Timer time;
  Random random;

  public gamePanel() {
    random = new Random();

    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);

    // Used to incidate that the gamePanel is the component to recieve user input, and nothing else.
    this.setFocusable(true);
    this.addKeyListener(new newKeyAdapter());

    startGame();
  }

  public void startGame() {
    // Add the fruit to the screen for the snake.
    newFood();

    // This makes it so that the snake starts moving.
    running = true;

    time = new Timer(delay, this);
    time.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  // Used to generate a new fruit in game for the player to go to.
  public void newFood() {
    // To find a random spot that we place the food to, we have to use the following variables.
       // To find the place where we "spawn" the food, we have to set a maximum boundry of screenWidth/unitSize which is the max number of squares on the board.
       // We then multiply the random number by the unitSize so that we can place it evenly on the board, and not halfway inbetween the squares.
          // This doesn't cancel out the unitSize at the bottom of the fraction, because the board is 600 pxiels long, not 25.
          // E.g.
             // Random number = random(600/25) * 25 => 20 * 25 => 500
             // We would place the food starting at the 500th pixel ending off at the 525th pixel, meaing that it takes the 20th square (500/25 = 20).
    foodX = random.nextInt((int)(screenWidth/unitSize)) * unitSize;
    foodY = random.nextInt((int)(screenHeight/unitSize)) * unitSize;
  }

  public void move() {

  }

  public void checkFood() {

  }

  public void checkCollision() {

  }

  public void gameOver(Graphics g) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  class newKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {

    }
  }
}
