import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class homeScreen extends JFrame {
  Panel textEditorArea = new Panel();

  JButton submitButton = new JButton("Submit");
  JLabel Information = new JLabel("Write the text below:");
  JTextArea textEditor = new JTextArea(30, 30);

  public homeScreen() {
    this.setSize(400,580);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setTitle("Rocco's Text Editor");

    textEditorArea.add(Information);
    textEditorArea.add(textEditor);
    textEditorArea.add(submitButton);
    this.add(textEditorArea);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
