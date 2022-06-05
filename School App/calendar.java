import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

class calendar extends JPanel {
  String[] calendarArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  String[] calendarWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
  public calendar() {
    this.setBounds(10, 35, 360, 155);
  }
}
