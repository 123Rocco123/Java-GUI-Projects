import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class deleteHomework {
  JFrame homeworkChangeFrame = new JFrame();

  JPanel homeworkConstainer = new JPanel(new GridLayout(0,1));
  JScrollPane scrollHWContainer = new JScrollPane(homeworkConstainer);

  public deleteHomework() {
    homeworkChangeFrame.setTitle("Modify Homework");
    homeworkChangeFrame.setSize(500, 500);
    homeworkChangeFrame.setVisible(true);
    homeworkChangeFrame.setLayout(null);
    homeworkChangeFrame.setLocationRelativeTo(null);

    scrollHWContainer.setBounds(10, 10, 480, 480);
    
  }
}
