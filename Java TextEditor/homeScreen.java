import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Scanner;

class homeScreen extends JFrame {
  // The variable below is used to see what opened the file.
     // If it was the "newFile" button, or the "openExistingFile" button.
  String whatOpened;

  Panel textEditorArea = new Panel();

  JButton submitButton = new JButton("Save");
  JButton newSubmitButton = new JButton("Save As");

  JLabel nameOfFileLabel = new JLabel("Name of the file:");
  JLabel Information = new JLabel("Write the text below:");

  JTextArea nameOfFile = new JTextArea(1, 30);
  JTextArea textEditor = new JTextArea(30, 30);

  File savedFile;

  public homeScreen(String newOrOld, File fileToOpen) {
    this.setSize(400,630);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setResizable(false);
    this.setTitle("Rocco's Text Editor");
    this.whatOpened = newOrOld;
    this.savedFile = fileToOpen;

    // Used so that the line automatically uses a "\n" when it gets to the edge of the textarea.
    textEditor.setLineWrap(true);

    textEditorArea.add(nameOfFileLabel);
    textEditorArea.add(nameOfFile);

    textEditorArea.add(Information);
    textEditorArea.add(textEditor);

    textEditorArea.add(submitButton);
    textEditorArea.add(newSubmitButton);

    this.add(textEditorArea);

    // If condition used to see if the user wants to open an existing file or not.
    if (whatOpened.equals("existing")) {
      textEditorArea.remove(nameOfFileLabel);
      textEditorArea.remove(nameOfFile);

      this.repaint();

      try {
        Scanner fileReader = new Scanner(savedFile);

        while(fileReader.hasNextLine()) {
          textEditor.append(fileReader.nextLine() + "\n");
        }
      } catch (FileNotFoundException e) {
        System.out.println(e);
      }
   }

    // submitButton Action Listener
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (whatOpened.equals("new")) {
          if ((nameOfFile.getText()).equals("") || (nameOfFile.getText()).length() > 20) {
            Error errorScreen = new Error();
          } // The if condition makes it so that when the user clicks the "New File" button, when the "sumbit" button is pressed, it will either create a new file, or save work to the new file.
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
        } else if (whatOpened.equals("existing")) {
            try {
              FileWriter newWriter = new FileWriter(savedFile);

              newWriter.write(textEditor.getText());
              newWriter.close();
            } catch (IOException error) {
              System.out.println("Error occured");
            }
        }
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
