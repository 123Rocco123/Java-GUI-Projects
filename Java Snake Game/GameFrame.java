import javax.swing.*;

class GameFrame extends JFrame {
  public GameFrame() {
    // The same concept of not having to use the variable once the class instance has been created.
    this.add(new gamePanel());
    this.setTitle("Snake");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    // Used to automatically size all of the components in the frame to their preferred size or larger.
    this.pack();
    this.setVisible(true);
    // This will make it so that it appears at the center of our screen.
    this.setLocationRelativeTo(null);
  }
}
