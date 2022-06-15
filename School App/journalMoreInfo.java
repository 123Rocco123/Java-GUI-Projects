import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.*;

class journalMoreInfo {
  JTextArea readArea = new JTextArea();

  JButton closeButton = new JButton("Close");
  JButton deleteButton = new JButton("Delete");

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

    closeButton.setBounds(145, 420, 100, 25);
    moreInfoFrame.add(closeButton);

    deleteButton.setBounds(255, 420, 100, 25);
    moreInfoFrame.add(deleteButton);

    // Close Button Action Listener
    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        moreInfoFrame.dispose();
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        File fileToReadFile = new File("./alerts", (fileToRead + ".txt"));

          int outcome = JOptionPane.showConfirmDialog(moreInfoFrame, "Are you sure you want to delete the file?");

          if (outcome == 0) {
            if (fileToReadFile.delete()) {
              JOptionPane.showMessageDialog(moreInfoFrame, "Successfully Deleted File");

              moreInfoFrame.dispose();
            } else {
              JOptionPane.showMessageDialog(moreInfoFrame, "Couldn't Delete File");
            }
          } else if (outcome == 1 || outcome == 2) {}
      }
    });

    // File reader try catch statement
    try {
      File fileToReadFile = new File("./alerts", (fileToRead + ".txt"));
      Scanner fileReader = new Scanner(fileToReadFile);

      while(fileReader.hasNextLine()) {
        readArea.append(fileReader.nextLine() + "\n");
      }

      fileReader.close();
    } catch (FileNotFoundException e) {}
  }
}
