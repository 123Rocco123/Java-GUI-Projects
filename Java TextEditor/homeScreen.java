import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class homeScreen extends JFrame {
  // The variable below is used to see what opened the file.
     // If it was the "newFile" button, or the "openExistingFile" button.
  String whatOpened;

  Panel textEditorArea = new Panel();

  JButton submitButton = new JButton("Save");
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

    // submitButton Action Listener
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (whatOpened.equals("new")) {
          try {
            File newFile = new File("newFile.txt");

            if (newFile.createNewFile()) {
              System.out.println("File created: " + newFile.getName());

              try {
                FileWriter newWriter = new FileWriter("newFile.txt");
                newWriter.write(textEditor.getText());
                newWriter.close();
              } catch (IOException error) {
                System.out.println("Error occured");
                error.printStackTrace();
              }
            } else {
              try {
                FileWriter newWriter = new FileWriter("newFile.txt");
                newWriter.write(textEditor.getText());
                newWriter.close();
              } catch (IOException error) {
                System.out.println("Error occured");
                error.printStackTrace();
              }
            }
          } catch (IOException error) {
            System.out.println("Error occured");
            error.printStackTrace();
          }
        }
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
