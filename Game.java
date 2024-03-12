import java.awt.*;
import java.awt.event.InputMethodListener;
import java.util.*;
import java.util.logging.Level;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends Thread implements KeyListener {
    private JFrame window;
    private JLabel player;
    private JLabel floor;
    private static boolean running;
    private int x;
    private int y;
    private boolean jumping;
    private boolean right;
    private boolean left;
    private Obsticle[] obsticles;
    private boolean falling;
    private Game(Player p){
        running = true;
        jumping = false;
        right = false;
        left = false;
        falling = false;
        window = new JFrame("game");
        window.setSize(600,500);
        //Image picture = new ImageIcon(getClass().getResource("greenFloor.png")).getImage();
        //ImageIcon reduced = new ImageIcon("greenFloor.png");
        x= 200;
        y = 380;
        this.player = p.getPlayer();
        player.setLocation(x,y);
        window.setLayout(null);
        window.add(player);
        player.setVisible(true);
        window.setVisible(true);
        floor = new JLabel("");
        floor.setLocation(0,400);
        floor.setVisible(true);
        floor.setBackground(Color.green);
        floor.setSize(600,100);
        floor.setOpaque(true);
        window.add(floor);
        window.addKeyListener(this);
        //window.setFocusable(true);
        //window.setFocusTraversalKeysEnabled(false);
    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_D||e.getKeyCode()== KeyEvent.VK_RIGHT){
            right = true;
        }
        if(e.getKeyCode()== KeyEvent.VK_A||e.getKeyCode()== KeyEvent.VK_LEFT){
            left = true;
        }
        if((e.getKeyCode()== KeyEvent.VK_W||e.getKeyCode()== KeyEvent.VK_UP)&&!jumping){
            jumping = true;
            jump();
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_D||e.getKeyCode()== KeyEvent.VK_RIGHT){
            right = false;
        }
        if(e.getKeyCode()== KeyEvent.VK_A||e.getKeyCode()== KeyEvent.VK_LEFT){
            left = false;
        }
        // if((e.getKeyCode()== KeyEvent.VK_W||e.getKeyCode()== KeyEvent.VK_UP)&&jumping){
        //     jumping = false;
        // }
        // jumping = false;
    }
    public void keyTyped(KeyEvent e) {
        //System.out.println("keyTyped");
        
    }
    private void updatePos(){
        if(right&&!jumping&&!falling)x+=5;else if(right&&(jumping||falling))x+=3;
        if(left&&!jumping&&!falling)x-=5;else if(left&&(jumping||falling))x-=3;
        try {
            Thread.sleep(25);
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
    private void game(){
        player.setLocation(x,y);
        updatePos();
        boolean needToFall = true;
        for(Obsticle o : obsticles){
            if(!(!jumping&&(x+20<o.getX()||x>o.getX()+o.getWidth())&&y<380&&!falling)){
                needToFall = false;
            }
        }
        if(y!=380 && needToFall)fall();
    }
    private void jump(){
        // SwingWorker worker = new SwingWorker() {
        //     @Override
        //     protected Object doInBackground() throws Exception {
        //         return null;
        //     }
        // };
        //worker.execute();
        Thread jump = new Thread(()->{
            int speed = 20;
            int g= 2;
            falling = false;
            while(speed>0){
                y-=speed;
                speed -= g;
                //System.out.println(this.y);
                game();
                try{
                    //Thread.sleep(25);
                }catch(Exception e){}
                // for(Obsticle o:obsticles){
                //     if(o.colisionInfo(x, y-speed, 20).isColiding()&&o.colisionInfo(x, y, 20).getSide()==1){
                //         speed = 0;
                //         y = o.getY()+o.getWidth();
                //         System.out.println(o.colisionInfo(x,y,20).getSide() + "");
                //     }
                //      /*
                //     else if(o.colisionInfo(x, y, 20).isColiding()&&o.colisionInfo(x, y, 20).getSide()==Report.LEFT){
                        
                //     }
                //     /* 
                //     else if(o.colisionInfo(x, y, 20).isColiding()&&o.colisionInfo(x, y, 20).getSide()==Report.LEFT){
                //         left = false;
                //     }
                //     */
                // }
            }
            boolean done = false;
            while(!done){
                if(y+speed<=380)
                    y+=speed;
                else y= 380;
                speed+=g;
                game();
                try{
                    //Thread.sleep(25);
                }catch(Exception e){}
                for(Obsticle o:obsticles){
                    if(o.colisionInfo(x, y+speed, 20).isColiding()/*&&o.colisionInfo(x, y, 20).getSide()==0*/){
                        done = true;
                        System.out.println(o.colisionInfo(x,y,20).getSide() + "");
                        y = o.getY()-20;
                    }
                    /*
                    else if(o.colisionInfo(x, y, 20).isColiding()&&o.colisionInfo(x, y, 20).getSide()==Report.RIGHT){
                        right = false;
                    }
                    else if(o.colisionInfo(x, y, 20).isColiding()&&o.colisionInfo(x, y, 20).getSide()==Report.LEFT){
                        left = false;
                    }
                    */
                }
                if(y>380)y = 380;
                if(y==380)done = true;
            }
            jumping = false;
         });
        jump.start();
    }

    private void fall(){
        Thread fall = new Thread(()->{
            falling = true;
            int speed  = 0;
            int g = 2;
            boolean done = false;
            while(!done&&falling){
                if(y+speed<=380)
                    y+=speed;
                else y= 380;
                speed+=g;
                game();
                if(y>380)y = 380;
                if(y==380){
                    done = true;
                    
                }

            }
            falling = false;
        });
        fall.start();
    } 

    private void levelOne(){
        Obsticle obs = new Obsticle(200, 300, 10, 80, window);
        Obsticle obs2 = new Obsticle(400, 350, 10, 80, window);
        obsticles = new Obsticle[2];
        obsticles[0] = obs;
        obsticles[1] = obs2;
    }
        
    public static void main(String[] args) {
        Game game = new Game(new Player());
        game.start();
        game.levelOne();
        while(running){
            game.game();
        }
    }
    //Thread thread = new Thread();
}