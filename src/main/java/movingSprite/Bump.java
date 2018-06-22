package movingSprite;

import javax.swing.*;
import java.awt.*;

public class Bump extends JFrame {

    public Bump() throws HeadlessException {
        initUi();
    }

    private void initUi() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Bump");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                Bump ex = new Bump();
                ex.setVisible( true );
            }
        } );

    }
}
