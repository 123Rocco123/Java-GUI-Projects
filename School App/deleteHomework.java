import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

class deleteHomework {
  // Contains the homework directory
  File directoryContainer = new File("./homework");

  // Homework Frame
  JFrame homeworkChangeFrame = new JFrame();

  JComboBox homeworkContainer = new JComboBox();

  // Used to display the homework
  JPanel homeworkConstainer = new JPanel(new GridLayout(0,1));
  JScrollPane scrollHWContainer = new JScrollPane(homeworkConstainer);

  // Remove HW Button
  JButton removeHomeworkButton = new JButton("Remove HW");

  public deleteHomework() {
    // JFrame Formatting
    homeworkChangeFrame.setTitle("Modify Homework");
    homeworkChangeFrame.setSize(500, 500);
    homeworkChangeFrame.setVisible(true);
    homeworkChangeFrame.setLayout(null);
    homeworkChangeFrame.setLocationRelativeTo(null);

    // ScrollPane Formatting
    scrollHWContainer.setBounds(10, 45, 465, 365);
    scrollHWContainer.setBorder(BorderFactory.createLineBorder(Color.black));
    homeworkChangeFrame.add(scrollHWContainer);

    // Remove Button Formatting
    // JComboBox Formatting
    // Remove Button Action Listener
  // Homework Checker Func
  }
}
