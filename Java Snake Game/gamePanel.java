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
    for (int i = bodyParts; i > 0; i--) {
      snakeArrayX[i] = snakeArrayX[i - 1];
      snakeArrayY[i] = snakeArrayY[i - 1];
    }

    switch(direction) {
      case 'U':
        snakeArrayY[0] = snakeArrayY[0] - unitSize;
        break;
      case 'D':
        snakeArrayY[0] = snakeArrayY[0] + unitSize;
        break;
      case 'L':
        snakeArrayX[0] = snakeArrayX[0] - unitSize;
        break;
      case 'R':
        snakeArrayX[0] = snakeArrayX[0] + unitSize;
        break;
    }
  }

  public void checkFood() {
    if ((snakeArrayX[0] == foodX) && (snakeArrayY[0] == foodY)) {
      bodyParts++;
      foodEaten++;
      newFood();
    }
  }

  public void checkCollision() {
    // Head colliding with the body
    for (int i = bodyParts; i > 0; i--) {
      if ((snakeArrayX[0] == snakeArrayX[i]) && (snakeArrayY[0] == snakeArrayY[i])) {
        running = false;
      }
    }

    // Head touches Left Border
    if (snakeArrayX[0] < 0) {
      running = false;
    }

    // Head touches Right Border
    if (snakeArrayX[0] > screenWidth) {
      running = false;
    }

    // Head touches Top Border
    if (snakeArrayY[0] < 0) {
      running = false;
    }

    // Head touches Bottom Border
    if (snakeArrayY[0] > screenHeight) {
      running = false;
    }

    if (running == false) {
      time.stop();
    }
  }

  public void draw(Graphics g) {
    if (running) {
      g.setColor(Color.red);

      // Coordinates, x and y, followed by size of object
      g.fillOval(foodX, foodY, unitSize, unitSize);

      for (int i = 0; i < bodyParts; i++) {
        if (i == 0) {
          g.setColor(Color.green);
          g.fillRect(snakeArrayX[i], snakeArrayY[i], unitSize, unitSize);
        } else {
          g.setColor(new Color(45, 180, 0));
          g.fillRect(snakeArrayX[i], snakeArrayY[i], unitSize, unitSize);
        }
      }

      g.setColor(Color.red);
      g.setFont(new Font("Ink Free", Font.BOLD, 40));
      FontMetrics metrics = getFontMetrics(g.getFont());
      g.drawString("Score: " + foodEaten, (screenWidth - metrics.stringWidth("Score: " + foodEaten)) / 2, g.getFont().getSize());
    } else {
        gameOver(g);
    }
  }

  public void gameOver(Graphics g) {
    g.setColor(Color.red);
    g.setFont(new Font("Ink Free", Font.BOLD, 40));
    FontMetrics metrics = getFontMetrics(g.getFont());
    g.drawString("Game Over", (screenWidth - metrics.stringWidth("Game Over")) / 2, screenHeight / 2);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (running) {
      move();
      checkFood();
      checkCollision();
    }
    repaint();
  }

  class newKeyAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      // The reason that we have an if statement in the cases is because of the fact that we don't want to allow the user to go into themselves in a straight line.
      switch(e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          if (direction != 'R') {
            direction = 'L';
          }
          break;

        case KeyEvent.VK_RIGHT:
          if (direction != 'L') {
            direction = 'R';
          }
          break;

        case KeyEvent.VK_UP:
          if (direction != 'D') {
            direction = 'U';
          }
          break;

        case KeyEvent.VK_DOWN:
          if (direction != 'U') {
            direction = 'D';
          }
          break;
      }
    }
  }
}
