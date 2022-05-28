import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class classes extends JFrame {
  JTextField newClass = new JTextField(30);
  JTextField time = new JTextField(30);

  public classes() {
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setTitle("Add New Class");
    this.setLayout(null);

    newClass.setBounds(10, 10, 465, 50);
    newClass.setText("Enter New Class Name");
    newClass.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(newClass);

    time.setBounds(10, 70, 465, 50);
    time.setText("Enter Time of the Class");
    time.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(time);
  }
}
