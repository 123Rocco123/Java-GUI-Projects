import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

class newHomework {
  JFrame homeworkFrame = new JFrame();

  JTextField newHomework = new JTextField();
  JTextField homeworkClass = new JTextField();
  JTextField dueDate = new JTextField();

  JButton saveAndQuit = new JButton("Save and Quit");

  File newHomeworkFile;

  public newHomework() {
    homeworkFrame.setSize(500, 265);
    homeworkFrame.setLocationRelativeTo(null);
    homeworkFrame.setVisible(true);
    homeworkFrame.setTitle("Add Homework");
    homeworkFrame.setLayout(null);

    homeworkFrame.add(fieldSetterFunc(10, 10, 465, 50, "Enter Homework Name Here", newHomework));
    homeworkFrame.add(fieldSetterFunc(10, 70, 465, 50, "Enter The Name of the Class For the Homework", homeworkClass));
    homeworkFrame.add(fieldSetterFunc(10, 130, 465, 50, "Enter Date The Homework is Due (mm/dd/yyyy)", dueDate));

    saveAndQuit.setBounds(175, 190, 150, 25);
    homeworkFrame.add(saveAndQuit);

    saveAndQuit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          if (!newHomework.getText().equals("Enter Homework Name Here")) {
            newHomeworkFile = new File("./homework", (newHomework.getText() + ".txt"));

            FileWriter homeworkWriter = new FileWriter(newHomeworkFile);

            homeworkWriter.write("Homework: " + newHomework.getText());
            homeworkWriter.write("\nClass: " + homeworkClass.getText());
            homeworkWriter.write("\nDue Date: " + dueDate.getText());
            homeworkWriter.close();

            homeworkFrame.dispose();
          } else {
            JOptionPane.showMessageDialog(homeworkFrame, "Error! Class For Homework not Assigned.");
          }
        } catch (IOException ex) {}
      }
    });
  }

  public JTextField fieldSetterFunc(int x, int y, int width, int height, String defaultText, JTextField name) {
    name.setBounds(x, y, width, height);
    name.setHorizontalAlignment(SwingConstants.CENTER);
    name.setText(defaultText);

    name.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (name.getText().equals(defaultText)) {
          name.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (name.getText().equals("")) {
          name.setText(defaultText);
        }
      }
    });

    return name;
  }
}
