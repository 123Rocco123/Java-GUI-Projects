import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.*;

class journalMoreInfo {
  JTextArea readArea = new JTextArea();

  JButton closeButton = new JButton("Close");

  JFrame moreInfoFrame = new JFrame("Journal Entries");

  String fileToRead = "";

  public journalMoreInfo(String fileName) {
    moreInfoFrame.setSize(500, 500);
    moreInfoFrame.setLocationRelativeTo(null);
    moreInfoFrame.setLayout(null);
    moreInfoFrame.setVisible(true);

    this.fileToRead = fileName;

    readArea.setBounds(10, 10, 480, 400);
    readArea.setEditable(false);
    moreInfoFrame.add(readArea);

    closeButton.setBounds(200, 420, 100, 25);
    moreInfoFrame.add(closeButton);

    // Close Button Action Listener
    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        moreInfoFrame.dispose();
      }
    });

    // File reader try catch statement
    try {
      File fileToReadFile = new File("./alerts", (fileToRead + ".txt"));
      Scanner fileReader = new Scanner(fileToReadFile);

      while(fileReader.hasNextLine()) {
        readArea.append(fileReader.nextLine() + "\n");
      }
    } catch (FileNotFoundException e) {}
  }
}
