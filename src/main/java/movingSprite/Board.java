package movingSprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private final int X = 140;
    private final int Y = 160;
    private final int DELAY = 15;
    private SpaceShip spaceShip;
    private Timer timer;
    //nowy kod
    private boolean game;
    private List<Ufo> aliens;
    private final int BOARD_WIDTH = 1000;
    private final int BOARD_HEIGHT = 700;

    //??
    private final int[][] pos = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
    };


    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener( new TAdapter() );
        setBackground( Color.BLACK );
        setFocusable( true );
        setDoubleBuffered( true );
        game = true;

        setPreferredSize( new Dimension( BOARD_WIDTH, BOARD_HEIGHT ) );
        spaceShip = new SpaceShip( X, Y );

        initAliens();

        timer = new Timer( DELAY, this );
        timer.start();
    }

    public void initAliens() {

        aliens = new ArrayList<>();

        for (int[] p : pos) {
            aliens.add( new Ufo( p[0], p[1] ) );
        }
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); //kolejnosc jest wazna
        // try {
        try {
            doDrawing( g );
        } catch (Exception e) {
            System.out.println( "Wystapil blad : " + e.getClass().getName() + " " + e.getMessage() );
        }
        if (game) {
            doDrawing( g );
        } else {
            drawGameOver( g );
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGameOver( Graphics g ) {
        String msg = "Game Over";
        Font small = new Font( "Helvetica", Font.BOLD, 14 );
        FontMetrics fm = getFontMetrics( small );

        g.setColor( Color.white );
        g.setFont( small );
        g.drawString( msg, (BOARD_WIDTH - fm.stringWidth( msg )) / 2,
                BOARD_HEIGHT / 2 );

    }

    private void doDrawing( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;

        if (spaceShip.isVisible()) {
            g2d.drawImage( spaceShip.getImage(), spaceShip.getX(),
                    spaceShip.getY(), this );
        }

        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            if (missile.isVisible()) {
                g2d.drawImage( missile.getImage(), missile.getX(),
                        missile.getY(), this );
            }
        }
        g.setColor( Color.WHITE );
        g.drawString( "Aliens left: " + aliens.size(), 15, 30 );
    }





    public void actionPerformed( ActionEvent e ) {

        inTheGame();

        updateMissiles();
        updateSpaceShip();
        updateAliens();

        checkBumps();

        repaint();
    }

    private void inTheGame () {
        if (!game) {
            timer.stop();
        }
    }
    private void updateSpaceShip() {

        if (spaceShip.isVisible()) {
            spaceShip.move();
        }
    }
    private void updateMissiles() {
        List<Missile> missiles = spaceShip.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get( i );

            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove( i );
            }
        }
    }
    private void updateAliens () {
        if (aliens.isEmpty()) {

            game = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Ufo a = aliens.get( i );
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove( i );
            }
        }
    }

    private void checkBumps() {

        Rectangle r3 = spaceShip.getBounds();

        for (Ufo alien : aliens) {
            Rectangle r2 = alien.getBounds();

            if (r3.intersects( r2 )) {
                spaceShip.setVisible( false );
                alien.setVisible( false );
                game = false;
            }
        }

        List<Missile> ms = spaceShip.getMissiles();

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Ufo alien : aliens) {

                Rectangle r2 = alien.getBounds();

                if (r1.intersects( r2 )) {
                    m.setVisible( false );
                    alien.setVisible( false );
                }

            }
        }
    }


    private class TAdapter extends KeyAdapter {


        public void keyReleased( KeyEvent e ) {
            spaceShip.keyReleased( e );
        }


        public void keyPressed( KeyEvent e ) {
            spaceShip.keyPressed( e );
        }
    }
}
