package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Ui extends JPanel{



  private JFrame frame;
  private Container container;
  private JPanel north;
  private JPanel east;
  private JPanel center;
  private JPanel south;
  private JPanel west;
  private JButton cCard1;
  private JButton cCard2;
  private JButton cCard3;
  private JButton cCard4;
  private JButton cCard5;
  private JButton fCard2;
  private JButton fCard3;
  private JButton fCard4;
  private JButton fCard5;
  private JButton pfieldCard2;
  private JButton pfieldCard1;
  private JButton pCard2;
  private JButton pCard1;
  private JButton pCard3;
  private JButton pCard4;
  private JButton pCard5;



  public Ui(MyFrame frame) {
    this.frame = frame;
    this.container = frame.getContentPane();
    BorderLayout borderLayout = (BorderLayout) container.getLayout();
    borderLayout.setVgap(10);
    borderLayout.setHgap(10);



  }


  public void paintNorth() {

    north = new JPanel();
    north.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

    JLabel com = new JLabel("com");
    com.setPreferredSize(new Dimension(200, 180));
    north.add(com);

    cCard1 = createButton("card");
    north.add(cCard1);
    cCard2 = createButton("card");
    north.add(cCard2);
    cCard3 = createButton("card");
    north.add(cCard3);
    cCard4 = createButton("card");
    north.add(cCard4);
    cCard5 = createButton("card");
    north.add(cCard5);

    container.add(north, BorderLayout.NORTH);
  }

  public void paintEast() {

    east = new JPanel();
    east.setPreferredSize(new Dimension(200, 400));
    east.setLayout(new GridLayout(0, 1, 0, 20));

    JButton cDeck = createButton("deck");
    east.add(cDeck);

    JButton turnEnd = createButton("turn end");
    east.add(turnEnd);

    JButton pDeck = createButton("deck");
    east.add(pDeck);

    container.add(east, BorderLayout.EAST);
  }

  public void paintCenter() {

    center = new JPanel();
    center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

    JPanel centerNorth = new JPanel();
    centerNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    JButton fCard1 = createButton("c\\n파도망령\\n8\\n5\\n8\\n0");
    fCard1.setIcon(new ImageIcon(getClass().getResource("/card1.png")));
    centerNorth.add(fCard1);

    fCard2 = createButton("card");
    centerNorth.add(fCard2);
    fCard3 = createButton("card");
    centerNorth.add(fCard3);
    fCard4 = createButton("card");
    centerNorth.add(fCard4);
    fCard5 = createButton("card");
    centerNorth.add(fCard5);

    JPanel centerSouth = new JPanel();

    pfieldCard1 = createButton("p\n화성암용암포식자\n5\n3\n4\n0");
    centerSouth.add(pfieldCard1);
    pfieldCard2 = createButton("card");
    centerSouth.add(pfieldCard2);
    JButton pfieldCard3 = createButton("card");
    centerSouth.add(pfieldCard3);
    JButton pfieldCard4 = createButton("card");
    centerSouth.add(pfieldCard4);
    JButton pfieldCard5 = createButton("card");
    centerSouth.add(pfieldCard5);

    center.add(centerNorth);
    center.add(centerSouth);

    container.add(center, BorderLayout.CENTER);
  }

  public void paintSouth() {


    south = new JPanel();
    south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));

    JPanel southNorth = new JPanel();
    southNorth.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));

    pCard1 = createButton("card");
    southNorth.add(pCard1);
    pCard2 = createButton("card");
    southNorth.add(pCard2);
    pCard3 = createButton("card");
    southNorth.add(pCard3);
    pCard4 = createButton("card");
    southNorth.add(pCard4);
    pCard5 = createButton("card");
    southNorth.add(pCard5);

    JLabel player = new JLabel("player");
    player.setPreferredSize(new Dimension(200, 180));
    southNorth.add(player);

    JPanel southSouth = new JPanel();

    JLabel console = new JLabel("console");
    southSouth.add(console);

    south.add(southNorth);
    south.add(southSouth);

    container.add(south, BorderLayout.SOUTH);

  }

  public void paintWest() {

    JPanel west = new JPanel();
    west.setMaximumSize(new Dimension(10, 10));
    frame.getContentPane().add(west, BorderLayout.WEST);
  }



  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(97, 150));
    button.setMaximumSize(new Dimension(97, 150));
    button.addActionListener(new BtnListenr());
    return button;
  }

  class BtnListenr implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      // 버튼 클릭시
      System.out.println("test");
    }

  }
}
