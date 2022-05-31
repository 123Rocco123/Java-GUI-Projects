import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.io.*;
import java.util.*;
import java.text.*;

class reminder {
  JFrame reminderFrame = new JFrame();

  JTextField reminder = new JTextField();
  JTextField dateField = new JTextField();


  public reminder() {
    reminderFrame.setSize(500, 205);
    reminderFrame.setLocationRelativeTo(null);
    reminderFrame.setVisible(true);
    reminderFrame.setTitle("Add New Reminder");
    reminderFrame.setLayout(null);
  }
}
