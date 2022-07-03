import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

class deleteHomework {
  // Contains the homework directory
  File directoryContainer = new File("./homework");

  // Homework Frame
  JFrame homeworkChangeFrame = new JFrame();

  String[] JComboBoxArray = {};
  JComboBox homeworkContainer = new JComboBox();

  // Used to display the homework
  JPanel homeworkConstainer = new JPanel(new GridLayout(0,1));
  JScrollPane scrollHWContainer = new JScrollPane(homeworkConstainer);

  // Remove HW Button
  JButton removeHomeworkButton = new JButton("Remove HW");

  // Complete Homework Button
  JButton completedHW = new JButton("Complete Homework");

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
    removeHomeworkButton.setBounds(88, 420, 150, 25);
    homeworkChangeFrame.add(removeHomeworkButton);

    // JComboBox Formatting
    homeworkAmountCheckFunc();
    homeworkContainer.setBounds(175, 10, 150, 25);
    homeworkChangeFrame.add(homeworkContainer);

    // Remove Button Action Listener
    removeHomeworkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!homeworkContainer.getSelectedItem().equals("")) {
          File fileToDelete = new File("./homework", (String)(homeworkContainer.getSelectedItem()));

          // Used to make sure that the user is sure to delete their homework.
             // JOptionPane returns an int value of 0 to 2.
          int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete: " + fileToDelete.getName());

          // Yes Option
          if (userChoice == 0) {
            if (fileToDelete.delete()) {
              JOptionPane.showMessageDialog(null, "Successfully Deleted File: " + fileToDelete.getName());

              homeworkChangeFrame.dispose();
            } else {
              JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });
  }

  // Homework Checker Func
  void homeworkAmountCheckFunc() {
    // Contains the amount of homework user has stored in the HW file
    int amountOfHomework = directoryContainer.list().length;

    // Contains the Array for the JComboBox
    JComboBoxArray = new String[amountOfHomework + 1];

    // Set the first index to 0.
       // This is to avoid the null point exception for the JComboBox.
    JComboBoxArray[0] = "";
    for (int i = 0; i < amountOfHomework; i++) {
      JComboBoxArray[i + 1] = directoryContainer.list()[i];
    }

    homeworkContainer = new JComboBox(JComboBoxArray);
  }
}
