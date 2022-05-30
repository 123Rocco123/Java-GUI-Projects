import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class newHomework extends JFrame {
class newHomework {
  JFrame homeworkFrame = new JFrame();

  JTextField newHomework = new JTextField();
  JTextField homeworkClass = new JTextField();


  JButton saveAndQuit = new JButton("Save and Quit");

  public newHomework() {
    homeworkFrame.setSize(500, 500);
    homeworkFrame.setLocationRelativeTo(null);
    homeworkFrame.setVisible(true);
    homeworkFrame.setTitle("Add Homework");
    homeworkFrame.setLayout(null);

    homeworkFrame.add(fieldSetterFunc(10, 10, 465, 50, "Enter Homework Name Here", newHomework));
    homeworkFrame.add(fieldSetterFunc(10, 70, 465, 50, "Enter The Name of the Class For the Homework", homeworkClass));

    saveAndQuit.setBounds(175, 130, 150, 25);
    homeworkFrame.add(saveAndQuit);

    saveAndQuit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        homeworkFrame.dispose();
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
