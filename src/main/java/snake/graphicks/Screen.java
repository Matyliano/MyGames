package snake.graphicks;

import snake.entities.Apple;
import snake.entities.BodyPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private Thread thread;
    private boolean running = false;

    private BodyPart b;
    private ArrayList<BodyPart> snake;  //lista czesci weza

    private Apple apple;
    private ArrayList<Apple> apples;

    private Random r;

    private int xCoor = 10;
    private int yCoor = 10;
    private int size = 5;

    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    private int ticks = 0;

    private Key key;

    public Screen() {
        setFocusable(true);

        key = new Key();
        addKeyListener(key);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();

        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<Apple>();

        start();
    }

    public void tick() {
        if (snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
        }

        if (apples.size() == 0) {
            int xCoor = r.nextInt(49);
            int yCoor = r.nextInt(49);

            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
        }

        for(int i = 0; i < apples.size(); i++) {
            if (xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
                size++;
                apples.remove(i);
                i--;
            }
        }

        for(int i = 0; i < snake.size(); i++){
            if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()){
                if(i != snake.size()-1){
                    stop();
                }
            }
        }

        if(xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49){
            stop();
        }

         ticks++;

         if(ticks > 2500000){  //to jest szybkosc weza
             if(right) xCoor++;
             if(left) xCoor--;
             if(up) yCoor--;
             if(down) yCoor++;

             ticks =0;

             b = new BodyPart(xCoor, yCoor,10);
             snake.add(b);

             if(snake.size() > size){
                 snake.remove(0);
             }
         }}


    public void paint(Graphics g){
          //te 3 rzeczy kolorują tło na czarno
        g.clearRect(0,0, WIDTH, HEIGHT);
        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);

        for(int i = 0; i < WIDTH / 10; i++){
            g.drawLine(i * 10,0,i * 10,HEIGHT);
        }
        for(int i=0; i < HEIGHT/10; i++){
            g.drawLine(0,i * 10,WIDTH,i*10);
        }
        for(int i =0; i< snake.size();i++){   //to nam narysuje kropke = weza
            snake.get(i).draw(g);
        }
        for(int i =0; i < apples.size(); i++){
            apples.get(i).draw(g);

            }
    }


    public void start(){
        running = true;
        thread = new Thread(this,"Game Loop");
        thread.start();
    }

    public void stop()  {
       running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(running){
            tick();
            repaint();
        }
    }

    private class Key implements KeyListener{

        public void keyTyped( KeyEvent e ) {

        }

        public void keyPressed( KeyEvent e ) {
           int key = e.getKeyCode();

           if(key == KeyEvent.VK_RIGHT && !left){
               up = false;
               down = false;
               right = true;
           }
           if(key == KeyEvent.VK_LEFT && !right){
               up = false;
               down = false;
               left = true;
           }
           if(key == KeyEvent.VK_UP && !down){
               left = false;
               right = false;
               up = true;
           }
           if(key == KeyEvent.VK_DOWN && !up){
               down = true;
               left = false;
               right = false;
           }
        }

        public void keyReleased( KeyEvent e ) {

        }
    }
}
