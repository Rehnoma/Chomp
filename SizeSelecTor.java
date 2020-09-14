//Rehnoma Binte Hassan
//201741691


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class SizeSelecTor extends JFrame {
        JButton Small, Medium, Large;


        /**
         * Constructor for objects of class
         */
        public SizeSelecTor() {
            setSize(500, 500);


            setLayout(new FlowLayout());

            Small = new JButton("SMALL");
            add(Small);
            Small.addActionListener(new Handler());

            Medium = new JButton("MEDIUM");
            add(Medium);
            Medium.addActionListener(new Handler());

            Large = new JButton("LARGE");
            add(Large);
            Large.addActionListener(new Handler());


            setVisible(true);

            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        public class Handler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource()==Small)
                {
                    new ChompBar(3,4);
                }
                if (e.getSource()==Medium)
                {
                    new ChompBar(4,5);
                }
                if (e.getSource()==Large)
                {
                    System.out.println("Button clicked");
                    new ChompBar(5,6);
                }
            }
        }
    }