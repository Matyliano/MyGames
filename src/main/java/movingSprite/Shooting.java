package movingSprite;

import javax.swing.*;
import java.awt.*;

public class Shooting extends JFrame {

    public Shooting() throws HeadlessException {
        initUi();
    }

    private void initUi() {
        add(new Board());
        setSize(1000, 700);
        setResizable(false);

        setTitle("Shooting missliles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String[] args ) {
        EventQueue.invokeLater( new Runnable() {
            @Override
            public void run() {
                Shooting ex = new Shooting();
                ex.setVisible( true );
            }
        } );
    }

}
