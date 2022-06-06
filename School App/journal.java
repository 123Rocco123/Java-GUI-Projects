import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class journal extends JFrame {
class journal {
  JFrame journalFrame = new JFrame("Add New Journal Entry");

  JTextField journalTitle = new JTextField();
  JTextArea journalEntry = new JTextArea();

  JButton submit = new JButton("Save Entry");

  public journal() {
    journalFrame.setSize(500, 500);
    journalFrame.setLocationRelativeTo(null);
    journalFrame.setVisible(true);
    journalFrame.setLayout(null);

    journalTitle.setBounds(10, 10, 465, 25);
    journalTitle.setBorder(BorderFactory.createLineBorder(Color.black));
    journalFrame.add(journalTitle);

    // X Y WIDHT HEIGHT
    journalEntry.setBounds(10, 10, 465, 300);
    journalEntry.setBorder(BorderFactory.createLineBorder(Color.black));
    this.add(journalEntry);

    submit.setBounds(200, 320, 100, 25);
    this.add(submit);
  }
}
