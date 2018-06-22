package movingSprite;

import javax.swing.*;
import java.awt.*;

public class MovingSpriteMain extends JFrame {

    public MovingSpriteMain() throws HeadlessException {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(1000, 700);
        setResizable(false);

        setTitle("Shooting missiles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingSpriteMain ex = new MovingSpriteMain();
            ex.setVisible(true);
        });
    }
}
