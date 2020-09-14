//Rehnoma Binte Hassan
//201741691


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ChompBar extends JFrame {

    JButton button[][];
    private JPanel North, South;
    private JLabel yourTurn, CompTurn, lose, win;
    int rows;
    int column;

    public ChompBar(int row, int columns) {
        super("the Chomp Game!");
        rows = row;
        column = columns;

        setSize(500, 500);

        North = new JPanel();
        yourTurn = new JLabel("It's Your turn");
        yourTurn.setVisible(true);
        CompTurn = new JLabel("Computer's turn");
        CompTurn.setVisible(false);
        lose = new JLabel("You have Lost, Sorry");
        lose.setVisible(false);
        win = new JLabel("You have Won the Chomp!! ");
        win.setVisible(false);

        North.add(yourTurn);
        North.add(CompTurn);
        North.add(lose);
        North.add(win);
        // north.setBackground(Color.YELLOW);

        South = new JPanel();
        South.setLayout(new GridLayout(rows, column, 0, 0));
        South.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        button = new JButton[rows][column];
        System.out.println(button.length);
        System.out.println(button[0].length);

        for (int i = 0; i < button.length; i++) {
            System.out.println("i is " + i);
            for (int j = 0; j < column; j++) {
                System.out.println("j is" + j);
                JButton newButton = new JButton();
                newButton.setBackground(Color.YELLOW);

                button[i][j] = newButton;
                // buttons[i][j].addActionListener(new Handler());
                South.add(button[i][j]);
            }

            button[0][0].setBackground(Color.GREEN);
            System.out.println("END");
        }

        for (int i = 0; i < button.length; i++) {
            for (int k = 0; k < button[0].length; k++) {
                button[i][k].addActionListener(new Handler());

            }

        }

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(North, BorderLayout.NORTH);
        getContentPane().add(South, BorderLayout.CENTER);


        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);}

 public void HaveEnded(String player){
            if (!(button[0][1].isVisible()) && !(button[1][0].isVisible())) {
                JLabel message = new JLabel(player + " have won");
                North.add(message);
            } else {
                whoWillPlay(player);
            }
        }
 public void whoWillPlay (String player){
            if (player == "you") {
                Sleeper sleep=new Sleeper();
                sleep.timer();
                CompTurn.setVisible(true);
                whenComputerPlays();

            } else {
                yourTurn.setVisible(true);
            }
        }

        public void whenComputerPlays(){
            int rw = new Random().nextInt(rows);
            int clmn = new Random().nextInt(column);

            while (!(button[rw][clmn].isVisible())) {
                if (rw - 1 >= 0) {
                    rw = rw - 1;
                }

                if (clmn - 1 >= 0) {
                    clmn = clmn - 1;
                }
            }
            if (rw == 0 && clmn == 0) {
                if (button[rw + 1][clmn].isVisible()) {
                    rw = rw + 1;
                } else {
                    clmn = clmn + 1;
                }
            }

            double x = button[rw][clmn].getLocation().getX();
            double y = button[rw][clmn].getLocation().getY();
            if (button[rw][clmn] == button[0][0]) {
                return;
            } else {
                Chomp(x, y);
            }
            CompTurn.setVisible(false);
            HaveEnded("Computer");

        }

        public void Chomp(double a,double b){
            for(int o=0; o<button.length; o++)
            {
                for(int p=0; p<button[0].length; p++)
                {
                    double w = button[o][p].getLocation().getX();
                    double x = button[o][p].getLocation().getY();
                    System.out.println("X1 is "+w);
                    System.out.println("y1 is "+w);
                    if (w>= a && x>= b){
                        button[o][p].setVisible(false);
                    }
                }
            }

        }
        public class Handler implements ActionListener
        {
            JButton newButton;
            public void actionPerformed(ActionEvent e)
            {
                newButton=(JButton)e.getSource();

                double x = newButton.getLocation().getX();
                double  y= newButton.getLocation().getY();//Syste+m.out.println("X CO-OD OF THE SELECTED BUTTON IS "+x);
                if (newButton == button[0][0])//System.out.println("y CO-OD OF THE SELECTED BUTTON IS "+y);
                {
                    return;
                }
                else
                {

                    Chomp(x, y);


                }

                yourTurn.setVisible(false);
                HaveEnded("You");


            }
        }
    }



