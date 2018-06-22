package ticTacToe;

import javax.swing.*;
import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TicTacToe extends JFrame {
    JPanel jPanel = new JPanel();
     private GameButton buttons[][] = new GameButton[3][3];

    public static void main(String[] args) {
        new TicTacToe();
    }

    public TicTacToe() {
        super();
        setSize(500,500);
        setTitle("     TicTacToe");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanel.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                jPanel.add(buttons[i][j] = new GameButton(i,j));
            }

        }
        jPanel.setBackground(Color.black);
        this.add(jPanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }



}
