import java.awt.*;

class Main {
  public static void main(String[] args) {
    homeScreen home = new homeScreen();
    makeScreen newScreen = new makeScreen();

    newScreen.screenProperties();
    home.screenProperties();
  }
}
