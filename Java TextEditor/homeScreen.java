import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;

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

  Boolean nonDefaultFileLocation = false;

  String newDirectory;
  String fileName;

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
      nonDefaultFileLocation = true;

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

   // Used for the Save As button
   newSubmitButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        // The File Chooser is used to choose the location and place where to save the file.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // We save the directory and user file name, and thnen remove the file name from the directory.
               // This is so that we can then write the new file to the the place that the user specified with the name that they specified with the FileWriter.
            String saveDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            fileName = fileChooser.getSelectedFile().getName();

            newDirectory = saveDirectory.replace(fileName, "");

            try {
              FileWriter fw = new FileWriter(new File(newDirectory, (fileName + ".txt")));

              fw.write(textEditor.getText());
              fw.close();
            } catch (IOException ex) {
              System.out.println(ex);
            }
        }
     }
   });

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
            // This is in case the file is located inside of the project directory.
            if (nonDefaultFileLocation == false) {
              try {
                FileWriter newWriter = new FileWriter(savedFile);

                newWriter.write(textEditor.getText());
                newWriter.close();
              } catch (IOException error) {
                System.out.println("Error occured");
              }
          } else {
              try {
                FileWriter fw = new FileWriter(new File(newDirectory, (fileName + ".txt")));

                fw.write(textEditor.getText());
                fw.close();
              } catch (IOException error) {
                System.out.println("Error occured");
              }
          }
        }
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
