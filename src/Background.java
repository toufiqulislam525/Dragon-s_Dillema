
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

public class Background extends JPanel implements ActionListener {

    Character hero;
    FireBall fireball;
    int enumber = 13;
    Enemy[] e1 = new Enemy[enumber];

    Image back, dead, over;
    ImageIcon i;
    Timer time;
    status health;
    int level;
    int levelLengthCounter = 0;
    int bedge = 590;//When the backgrounds edge is displayed
    int bwidth = 2500;//The backgrounds width
    int fx, fy;
    boolean lost = false;
    int h = 0;
    int score = 0;
    static Font font = new Font("Monospaced", Font.BOLD, 40);
    
    public Background(int l) {
        level = l;
        health = new status();
        hero = new Character(level);

        if (l == 1) {
            i = new ImageIcon("C:\\set1/Back.png");
            e1[0] = new Enemy(1800, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[1] = new Enemy(3200, 710, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[2] = new Enemy(3600, 720, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[3] = new Enemy(4000, 720, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[4] = new Enemy(4500, 720, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[5] = new Enemy(5000, 710, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[6] = new Enemy(5300, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[7] = new Enemy(5500, 710, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[8] = new Enemy(5800, 700, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[9] = new Enemy(6200, 610, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[10] = new Enemy(6500,710, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[11] = new Enemy(7000, 790, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[12] = new Enemy(7100, 720, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");

        }
        if (l == 2) {
            i = new ImageIcon("C:\\set1/Back2.png");
            e1[0] = new Enemy(1920, 710, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[1] = new Enemy(3000, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[2] = new Enemy(3700, 600, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[3] = new Enemy(4300, 790, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[4] = new Enemy(4800, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[5] = new Enemy(5000, 800, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[6] = new Enemy(5500, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[7] = new Enemy(5900, 800, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[8] = new Enemy(6200, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[9] = new Enemy(6500, 750, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[10] = new Enemy(6800, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[11] = new Enemy(6900, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
            e1[12] = new Enemy(7200, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
        }
        if (l == 3) {
            i = new ImageIcon("C:\\set1/Back3.png");
            e1[0] = new Enemy(1920, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
            e1[1] = new Enemy(3200, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[2] = new Enemy(3600, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[3] = new Enemy(3800, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
            e1[4] = new Enemy(4400, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[5] = new Enemy(4800, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
            e1[6] = new Enemy(5200, 700, "C:\\set1/enemy2.png", "C:\\set1/enemy2_2.png");
            e1[7] = new Enemy(5500, 600, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[8] = new Enemy(5900, 600, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");
            e1[9] = new Enemy(6100, 700, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[10] = new Enemy(6300, 600, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[11] = new Enemy(6400, 800, "C:\\set1/enemy1.png", "C:\\set1/enemy1_2.png");
            e1[12] = new Enemy(6700, 500, "C:\\set1/enemy3.png", "C:\\set1/enemy3_2.png");

        }

        addKeyListener(new Action());
        setFocusable(true);

        ImageIcon d = new ImageIcon("C:\\set1/go.png");
        ImageIcon o = new ImageIcon("C:\\set1/leveldone.png");
        back = i.getImage();
        dead = d.getImage();
        over = o.getImage();
        time = new Timer(7, this);
        time.start();
        Frame f = new Frame();
        fx = f.x;
        fy = f.y;
    }


    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        ArrayList fireballs = Character.getFireBalls();
        for (int w = 0; w < fireballs.size(); w++) {
            //This is how to get a current element in an arrayList
            //similar to x[2] in a normal array
            FireBall ball = (FireBall) fireballs.get(w);//draw:
            if (ball.getVisible() == true) {
                ball.move();
            } else {
                fireballs.remove(w);
            }
        }

        hero.move();

        for (int i = 0; i < enumber; i++) {
            e1[i].move(hero.getdx(), hero.getLeft());
        }

        repaint();

    }

    public void checkCollisions() {

        Rectangle[] r = new Rectangle[enumber];
        for (int i = 0; i < enumber; i++) {
            r[i] = e1[i].getBounds();
        }
        ArrayList fireballs = Character.getFireBalls();
        for (int w = 0; w < fireballs.size(); w++) {
            FireBall m = (FireBall) fireballs.get(w);
            Rectangle m1 = m.getBounds();
            for (int i = 0; i < enumber; i++) {
                if (r[i].intersects(m1) && e1[i].Alive()) {
                    e1[i].isAlive = false;
                    m.visible = false;
                    score++;

                }
            }
        }
        Rectangle d = hero.getBounds();
        boolean clawOn = hero.clawSwitch;

        for (int i = 0; i < enumber; i++) {
            if ((d.intersects(r[i]) && e1[i].isAlive)) {
                 lost = true;
                h++;
            }
        }

        for (int i = 0; i < enumber; i++) {
            if ((d.intersects(r[i]) && e1[i].isAlive && clawOn)) {
                lost= false;
                e1[i].isAlive = false;
                System.out.println("lost" + lost);
                h--;
                score++;
                //init();
            }
        }

    }


    boolean levelComplete() {

        if (hero.nx == 5000) {
            levelLengthCounter++;
            return false;
        }
        if (levelLengthCounter == 2) {
            return true;
        } else {
            return false;
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;


        if (lost) {

            //System.out.println("died here");
            g2D.drawImage(dead, 0, 0, 1920, 1080, this);
            g2D.setFont(font);
            g2D.setColor(Color.RED);
            g2D.drawString("score: " + score, 1920 / 2 - 50, 1080 / 2 + 30);
            time.stop();
            String FILENAME = "E:\\File.txt";
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                String content = "0";

                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                bw.write(content);

            } catch (IOException ee) {

                ee.printStackTrace();

            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }

            //time.stop();
            //init();
        } else if (levelComplete()) {
            g2D.drawImage(over, 0, 0, 1920, 1080, this);
            g2D.setFont(font);
            g2D.setColor(Color.RED);
            g2D.drawString("score: " + score, 1920 / 2 - 50, 1080 / 2 + 30);

            if (level == 1 || level == 2) {

                String FILENAME = "E:\\File.txt";
                BufferedWriter bw = null;
                FileWriter fw = null;

                try {

                    String content = Integer.toString(score);

                    fw = new FileWriter(FILENAME);
                    bw = new BufferedWriter(fw);
                    bw.write(content);

                } catch (IOException ee) {

                    ee.printStackTrace();

                } finally {

                    try {

                        if (bw != null) {
                            bw.close();
                        }

                        if (fw != null) {
                            fw.close();
                        }

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }

                }
            }

            //init(this.level+1);
            time.stop();

        } else {

            //Mainly nx2 = 1920 is needed only once after that nx2 behaves like nx cause 
            //At the first time fx - nx2(1920) is 0 after that point every nx2 would be 0 
            //so the frame will be drawn in 1920
            //nx2 is only nedded because we need to start the game at 0 point after that
            //Whenever character founds the edge we need to draw background at 1920
            g2D.drawImage(back, (fx - 20) - hero.nx2, 0, bwidth, 1080, this); // Draw in the first frame        

            if ((hero.x - bedge) % (bwidth * 2) == 0) // In every 5000 frames hero.nx is getting 0
            {
                hero.nx = 0;
            }
            if ((hero.x - bedge - bwidth) % (bwidth * 2) == 0) // In every 5000 frames hero.nx2 is getting 0
            {
                hero.nx2 = 0;

            }

            if (hero.x >= bedge) {
                g2D.drawImage(back, (fx - 20) - hero.nx, 0, bwidth, 1080, this); // Draw in the last frame

            }

            g2D.drawImage(hero.getImage(), hero.left, hero.up, 250, 250, this);//

            g2D.drawImage(health.getstatusImage(h), health.posX, health.posY, 400, 129, this);

            ArrayList fireballs = Character.getFireBalls();
            for (int w = 0; w < fireballs.size(); w++) {
                FireBall ball = (FireBall) fireballs.get(w);
                g2D.drawImage(ball.getImage(), ball.getX(), ball.getY(), 96, 96, this);

            }

            for (int i = 0; i < enumber; i++) {

                if (e1[i].Alive() == true) {
                    g2D.drawImage(e1[i].getImage(), e1[i].getX(), e1[i].getY(), 250, 250, this);
                }
            }

            g2D.setFont(font);
            g2D.setColor(Color.RED);
            g2D.drawString("score: " + score, 50, 180);
            if(level==2 || level==3)
            {
                g2D.drawString("Fireballs left: " + hero.ammo, 50, 230);
            }
            g2D.drawString("Claws left: " + hero.clawAmmo, 50, 270);

            //Displaying Game controls
            if (level == 1) {
                if (hero.nx >= 0 && hero.nx <= 1920 * 2 && levelLengthCounter == 0) {
                    g2D.drawString("        Use Directional keys", 1920 / 2, 180);
                    g2D.drawString("   for moving left, right and jump.", 1920 / 2, 220);
                    g2D.drawString("     Press and hold Z to punch.", 1920 / 2, 260);
                }
            }
            if (level == 2) {
                if (hero.nx >= 0 && hero.nx <= 1920 * 2 && levelLengthCounter == 0) {
                    g2D.drawString("             New Power!", 1920 / 2, 180);
                    g2D.drawString("        press x for a fireball", 1920 / 2, 220);
                    g2D.drawString(" Press and hold X for continuous bursts.", 1920 / 2, 260);
                }
            }
            if (level == 3) {
                if (hero.nx >= 0 && hero.nx <= 1920 * 2 && levelLengthCounter == 0) {
                    g2D.drawString("             New Power!", 1920 / 2, 180);
                    g2D.drawString(" First take a step then press SPACE ", 1920 / 2, 220);
                    g2D.drawString("     for fly mode.When in land press", 1920 / 2, 260);
                    g2D.drawString("       C to return to walking.", 1920 / 2, 300);
                }
            }

        }
    }

    private class Action extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            hero.KeyPressed(e);
        }

        public void keyReleased(KeyEvent e) {

            hero.KeyReleased(e);

        }

    }

}
