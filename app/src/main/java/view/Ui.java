package view;

import dolgame.Field;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ui extends JPanel {


    private JFrame frame;
    private Container container;
    private JPanel north;
    private JPanel east;
    private JPanel center;
    private JPanel south;
    private JPanel west;
    private JButton cHandCard1;
    private JButton cHandCard2;
    private JButton cHandCard3;
    private JButton cHandCard4;
    private JButton cHandCard5;
    /*private JButton cfieldCard1;
    private JButton cfieldCard2;
    private JButton cfieldCard3;
    private JButton cfieldCard4;
    private JButton cfieldCard5;
    private JButton pfieldCard1;
    private JButton pfieldCard2;
    private JButton pfieldCard3;
    private JButton pfieldCard4;
    private JButton pfieldCard5;*/
    JButton[] cFieldCards = new JButton[5];
    JButton[] pFieldCards = new JButton[5];
    private JButton pHandCard1;
    private JButton pHandCard2;
    private JButton pHandCard3;
    private JButton pHandCard4;
    private JButton pHandCard5;

    Field field = new Field();

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

        cHandCard1 = createButton("card");
        north.add(cHandCard1);
        cHandCard2 = createButton("card");
        north.add(cHandCard2);
        cHandCard3 = createButton("card");
        north.add(cHandCard3);
        cHandCard4 = createButton("card");
        north.add(cHandCard4);
        cHandCard5 = createButton("card");
        north.add(cHandCard5);

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

        for (int i = 0; i < cFieldCards.length; i++) {
            String[] buttonText = field.getComputerFieldArray();
            cFieldCards[i] = createButton(buttonText[i]);
            centerNorth.add(cFieldCards[i]);
        }
        /*cfieldCard1 = createButton("c\n파도 망령\n8\n5\n8\n0");
        //fCard1.setIcon(new ImageIcon(getClass().getResource("/card1.png")));
        centerNorth.add(cfieldCard1);

        cfieldCard2 = createButton("card");
        centerNorth.add(cfieldCard2);
        cfieldCard3 = createButton("card");
        centerNorth.add(cfieldCard3);
        cfieldCard4 = createButton("card");
        centerNorth.add(cfieldCard4);
        cfieldCard5 = createButton("card");
        centerNorth.add(cfieldCard5);*/

        JPanel centerSouth = new JPanel();

        for (int i = 0; i < pFieldCards.length; i++) {
            String[] buttonText = field.getPlayerFieldArray();
            pFieldCards[i] = createButton(buttonText[i]);
            centerSouth.add(pFieldCards[i]);
        }
        /*
                pfieldCard1 = createButton("p\n화성암 용암포식자\n5\n3\n4\n0");
                centerSouth.add(pfieldCard1);

                pfieldCard2 = createButton("card");
                centerSouth.add(pfieldCard2);
                pfieldCard3 = createButton("card");
                centerSouth.add(pfieldCard3);
                pfieldCard4 = createButton("card");
                centerSouth.add(pfieldCard4);
                pfieldCard5 = createButton("card");
                centerSouth.add(pfieldCard5);*/

        center.add(centerNorth);
        center.add(centerSouth);

        container.add(center, BorderLayout.CENTER);
    }

    public void paintSouth() {


        south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));

        JPanel southNorth = new JPanel();
        southNorth.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));

        pHandCard1 = createButton("card");
        southNorth.add(pHandCard1);
        pHandCard2 = createButton("card");
        southNorth.add(pHandCard2);
        pHandCard3 = createButton("card");
        southNorth.add(pHandCard3);
        pHandCard4 = createButton("card");
        southNorth.add(pHandCard4);
        pHandCard5 = createButton("card");
        southNorth.add(pHandCard5);

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
        button.addActionListener((e) ->{
            field.attack(button.getText());

            String who = text.split("\n")[0];   //p or c
            if (who.equals("p")) {
                for (int i = 0; i < pFieldCards.length-1; i++) {
                    if (field.getPlayerFieldArray()[i] != null) {
                        pFieldCards[i].setText(field.getPlayerFieldArray()[i]);
                    }else{
                        pFieldCards[i].setText("");
                    }
                }
            } else {
                for (int i = 0; i < cFieldCards.length-1; i++) {
                    if(field.getComputerFieldArray()[i] != null){
                        cFieldCards[i].setText(field.getComputerFieldArray()[i]);
                    }else{
                        cFieldCards[i].setText("");
                    }
                }
            }
        });
        return button;
    }
}
