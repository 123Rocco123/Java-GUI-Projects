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

  char direction = "R";
  boolean running = false;

  Timer time;
  Random random;

  public gamePanel() {
  }

  public void startGame() {

  }

  public void paintComponent(Graphics g) {

  }

  public void draw(Graphics g) {

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

  public class keyAdapter extends keyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {

    }
  }
}
