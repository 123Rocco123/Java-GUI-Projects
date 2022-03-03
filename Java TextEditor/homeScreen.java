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

  JLabel nameOfFileLabel = new JLabel("Name of the file:");
  JLabel Information = new JLabel("Write the text below:");

  JTextArea nameOfFile = new JTextArea(1, 30);
  JTextArea textEditor = new JTextArea(30, 30);

  public homeScreen() {
    this.setSize(400,630);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setTitle("Rocco's Text Editor");

    textEditorArea.add(nameOfFileLabel);
    textEditorArea.add(nameOfFile);

    textEditorArea.add(Information);
    textEditorArea.add(textEditor);

    textEditorArea.add(submitButton);
    this.add(textEditorArea);

    // submitButton Action Listener
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!(nameOfFile.equals(null))) {
          Error errorScreen = new Error();
        } // The if condition makes it so that when the user clicks the "New File" button, when the "sumbit" button is pressed, it will either create a new file, or save work to the new file.
        else if (whatOpened.equals("new")) {
          try {
            String nameFile = nameOfFile.getText();
            // We first create the file.
            File newFile = new File(nameFile + ".txt");

            if (newFile.createNewFile()) {
              System.out.println("File created: " + newFile.getName());

              try {
                FileWriter newWriter = new FileWriter(nameFile + ".txt");
                newWriter.write(textEditor.getText());
                newWriter.close();
              } catch (IOException error) {
                System.out.println("Error occured");
                error.printStackTrace();
              }
            } else {
              try {
                FileWriter newWriter = new FileWriter(nameFile + ".txt");
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
