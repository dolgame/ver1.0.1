package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MyFrame extends JFrame {

  private MyFrame frame;
  Ui ui;
  
  
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 1000;

    public MyFrame() {
      this.frame = this;
      ui = new Ui(frame);
      init();
        ui.paintNorth();
        ui.paintEast();
        ui.paintCenter();
        ui.paintSouth();
        ui.paintWest();
        setVisible(true);
    }

    public void init() {
        setSize(WIDTH, HEIGHT);
        setTitle("dolGame");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
}
