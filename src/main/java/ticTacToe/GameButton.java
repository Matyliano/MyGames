package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton extends JButton implements ActionListener {

    private static ImageIcon X;
    private static ImageIcon O;
    private static byte value = 0;
    private int Xpos = 0;
    private int Ypos = 0;
    private static byte tour = 0;
    private Graphics paintContour;
    private  static boolean end = false;
    private static byte Tour = 0;
    private static int [][] board = new int [3][3];

    public static byte getTour () {
        return Tour;
    }


    public GameButton(int a, int b) {
        X = new ImageIcon("C:\\Users\\joann\\Desktop\\obrazki\\X.png");
        O = new ImageIcon("C:\\Users\\joann\\Desktop\\obrazki\\O.png");
        Xpos = a;
        Ypos = b;
        this.addActionListener(this);
        this.setVisible(true);
        switch (a) {
            case 0:
                switch (b) {
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;
                }
                break;
            case 1:
                switch (b) {
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
                        break;
                }
                break;

            case 2:
                switch (b) {
                    case 1:

                        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
                        break;
                }
                break;
        }
        this.setContentAreaFilled(false);
        this.setOpaque(false);
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        value++;
        value %= 3;


    }}



