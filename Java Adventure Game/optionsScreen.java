import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class optionsScreen extends JFrame {
  static GraphicsDevice device = GraphicsEnvironment
        .getLocalGraphicsEnvironment().getScreenDevices()[0];

  JLabel resolution = new JLabel("Screen Resolution");
  String[] resolutions = {"Programmers Choice", "Fullscreen"};

  JPanel optionsPanel = new JPanel();

  public optionsScreen() {
    final JFrame frame = new JFrame("Display Mode");

    this.setSize(300, 300);
    this.setLocation(750, 200);
    this.setLayout(null);
    this.add(optionsPanel);
    this.setTitle("")

    optionsPanel.setBounds(10, 10, 265, 240);
    optionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    optionsPanel.add(resolution);
    resolution.setBounds(150, 10, 100, 25);

    JComboBox<String> resolutionList = new JComboBox<String>(resolutions);
    resolutionList.setSelectedIndex(0);
    resolutionList.setBounds(150, 45, 100, 25);
    optionsPanel.add(resolutionList);

    this.setVisible(true);
  }
}
