import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class journal extends JFrame {
  JTextArea journalEntry = new JTextArea();

  JButton submit = new JButton("Save Entry");

  public journal() {
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setTitle("Add New Journal Entry");
    this.setLayout(null);

    // X Y WIDHT HEIGHT
    journalEntry.setBounds(10, 10, 465, 300);
    journalEntry.setBorder(BorderFactory.createLineBorder(Color.black));
    this.add(journalEntry);

    submit.setBounds(200, 320, 100, 25);
    this.add(submit);
  }
}
