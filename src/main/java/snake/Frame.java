package snake;



import snake.graphicks.Screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("snake");
        setResizable(false);    //poczytac

        init();
    }

    public void init() {
        setLayout(new GridLayout(1, 1, 0,0));
        Screen s = new Screen();
        add(s);

        pack();

        setLocationRelativeTo(null);   //poczytac
        setVisible(true);
    }

    public static void main( String[] args ) {
        new Frame();
    }
}
