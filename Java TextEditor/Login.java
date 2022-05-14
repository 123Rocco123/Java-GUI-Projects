import java.io.File;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

class Login extends JFrame {
  JPanel ButtonsPanel = new JPanel();

  JButton newFile = new JButton("New File");
  JButton openExistingFile = new JButton("Open File");
  JButton quitProgram = new JButton("Close");

  JTextArea information = new JTextArea("Hello,\n\nMy name is Rocco Petruccio, and this is the first \"app\" \nwhich I've created.\n\nI hope that you enjoy it.", 10, 30);

  public Login() {
    this.setSize(400,400);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setTitle("Home Screen");

    information.setEditable(false);

    ButtonsPanel.add(information);
    ButtonsPanel.add(newFile);
    ButtonsPanel.add(openExistingFile);
    ButtonsPanel.add(quitProgram);
    this.add(ButtonsPanel);

    // The code below is used to dipose of the current window, when the "Open File" button is pressed.
    openExistingFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        // Used to create an object of the fileChooser Java Class.
        JFileChooser fileChooser = new JFileChooser();

        // The reason that we add "." is because of the fact that it will make it so that the current directory is where the project is store is opened.
        fileChooser.setCurrentDirectory(new File("."));

        // Used to open a window selecting a file to open.
           // The reason that we store it is to see if the user has selected a file or not.
           // If a file has been selected, then the value of the response variable will be "1" or else it will be "0".
        int response = fileChooser.showOpenDialog(null);

        // The "APPROVE_OPTION" is used instead of having to
        if (response == JFileChooser.APPROVE_OPTION) {
          File fileToOpen = new File(fileChooser.getSelectedFile().getAbsolutePath());

          homeScreen mainScreen = new homeScreen("existing", fileToOpen);

          mainScreen.savedFile = fileToOpen;
        }
      }
    });

    // The code below is used to dipose of the current window, when the "New File" button is pressed.
    newFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        homeScreen mainScreen = new homeScreen("new", null);
        mainScreen.whatOpened = "new";
      }
    });

    quitProgram.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
