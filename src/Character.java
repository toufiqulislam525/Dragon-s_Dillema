
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Character {

    int walkAnimationCounter = 0;
    int flyAnimationCounter = 0;
    int clawAnimationCounter = 0;
    int level;
    int x, dx;
    int y, dy;
    int defaultspeed = 4;
    int upSpeed = 12, downSpeed = 2, jumpLimit = 40;
    boolean jumpSwitch = false, facingRight = true, standSwitch = true, flySwitch = false, clawSwitch = false, fireSwitch = false;

    int left, constleft;
    int up;
    Image character;
    int fx, fy;
    int nx, nx2;
    int ammo = 10;
    int clawAmmo=15;
    
    ImageIcon stand = new ImageIcon("C:\\set1/stand.png");
    ImageIcon walk1 = new ImageIcon("C:\\set1/walk1.png");
    ImageIcon walk2 = new ImageIcon("C:\\set1/stand.png");
    ImageIcon walk3 = new ImageIcon("C:\\set1/walk3.png");
    ImageIcon walk4 = new ImageIcon("C:\\set1/walk4.png");

    ImageIcon standLeft = new ImageIcon("C:\\set1/standLeft.png");
    ImageIcon walk1Left = new ImageIcon("C:\\set1/walk1Left.png");
    ImageIcon walk2Left = new ImageIcon("C:\\set1/standLeft.png");
    ImageIcon walk3Left = new ImageIcon("C:\\set1/walk3Left.png");
    ImageIcon walk4Left = new ImageIcon("C:\\set1/walk4Left.png");

    ImageIcon jump = new ImageIcon("C:\\set1/jump1.png");
    ImageIcon jumpL = new ImageIcon("C:\\set1/jump1L.png");

    ImageIcon claw1 = new ImageIcon("C:\\set1/claw1.png");
    ImageIcon claw2 = new ImageIcon("C:\\set1/claw2.png");

    ImageIcon fire = new ImageIcon("C:\\set1/fire.png");

    ImageIcon fly1 = new ImageIcon("C:\\set1/fly1.png");
    ImageIcon fly2 = new ImageIcon("C:\\set1/fly2.png");
    ImageIcon flyfire = new ImageIcon("C:\\set1/flyfire.png");

    static ArrayList fireballs;

    public static ArrayList getFireBalls() {
        return fireballs;
    }

    public Character(int l) {
        level = l;
        x = 10;
        y = 700;
        left = 250;
        constleft = left;
        up = y;
        nx = 0;
        character = stand.getImage();
        Frame f = new Frame();
        fx = f.x;
        fy = f.y;
        nx2 = fx - 20;
        nx = 0;
        fireSwitch = false;
        fireballs = new ArrayList();
        walkAnimationCounter = 0;
        flyAnimationCounter  = 0;
        clawAnimationCounter = 0;
        
    }

    public int getX() {
        return x;
    }

    public int getLeft() {
        return left;
    }

    public int getnX() {
        return nx;
    }

    public int getnX2() {
        return nx2;
    }

    public int getdx() {
        return dx;
    }

    public Rectangle getBounds() {
        return new Rectangle(left, up, 200, 200);
    }

    public void fire()//Method to run when when fired
    {
        {
                if (ammo > 0){
                        ammo--;
                //Create a new fireball object and add it to
                //array "list" of all fireball on screen.
                FireBall z = new FireBall((left + 120), (up + 80));
                fireballs.add(z);}
        }
    }

    public void move() {

        if (dx != -defaultspeed) {
            if (left + dx <= constleft) {
                left = left + dx;
            } else {
                x = x + dx;
                nx2 = nx2 + dx;
                nx = nx + dx;
            }
        } else if (left + dx > defaultspeed * 2) {
            left = left + dx;
        }
        if (jumpSwitch == true) {
            jump();
        }

        if (up == y && standSwitch == true) {

            if (facingRight == true) {
                character = stand.getImage();
            } else {
                character = standLeft.getImage();
            }
        }

        if (flySwitch == true) {
            fly();

        }

    }

    private void fly() {

        if (dx != -defaultspeed) {
            if (left + dx <= constleft) {
                left = left + dx;
            }

        } else if (left + dx > 2) {
            left = left + dx;
        }
        if (up >= 0 && up <= y) {
            up = up + dy;
            if (up > y) {
                int difference = up - y;
                up = up - difference;
            }
            if (up < 0) {
                int difference = 0 - up;
                up = up + difference;
            }
            // System.out.println("posY:"+up);
        }

    }

    private void jump() {

        if (up + dy >= y - (jumpLimit * upSpeed)) {

            up = up + dy;
            if (up > y) {
                int difference = up - y;
                //System.out.println("posDIFFRENCE:"+difference);
                up = up - difference;

            }
            if (up == y - (jumpLimit * upSpeed)) {
                land();
            }
        }

    }

    public void land() {

        if (up != y) {
            dy = downSpeed;
            jump();
        }

    }

    //walking animation for right
    Image walkAnimationRight() {

        if (walkAnimationCounter > 16) {                     //skipping 4 frames for smoothness
            walkAnimationCounter = 0;
        }
        if (walkAnimationCounter == 0) {
            character = walk1.getImage();

        }
        if (walkAnimationCounter == 4) {
            character = stand.getImage();
        }
        if (walkAnimationCounter == 8) {
            character = walk3.getImage();
        }

        if (walkAnimationCounter == 12) {
            character = walk4.getImage();
        }
        //System.out.println("walkanimationcounter"+walkAnimationCounter);
        walkAnimationCounter++;
        return character;
    }

    //walking animation for Left
    Image walkAnimationLeft() {

        if (walkAnimationCounter > 16) {                     //skipping 4 frames for smoothness
            walkAnimationCounter = 0;
        }
        if (walkAnimationCounter == 0) {
            character = walk1Left.getImage();

        }
        if (walkAnimationCounter == 4) {
            character = standLeft.getImage();
        }
        if (walkAnimationCounter == 8) {
            character = walk3Left.getImage();
        }

        if (walkAnimationCounter == 12) {
            character = walk4Left.getImage();
        }

        walkAnimationCounter++;
        return character;
    }

    Image flyAnimation() {
        if (flyAnimationCounter > 20) {                     //skipping 4 frames for smoothness
            flyAnimationCounter = 0;
        }
        if (flyAnimationCounter == 0) {
            character = fly1.getImage();

        }
        if (flyAnimationCounter == 10) {
            character = fly2.getImage();
        }

        flyAnimationCounter++;
        return character;
    }

    Image clawAnimation() {
        if (clawAnimationCounter > 24) {                     //skipping 4 frames for smoothness
            clawAnimationCounter = 0;
        }
        if (clawAnimationCounter == 0) {
            character = claw1.getImage();

        }
        if (clawAnimationCounter == 14) {
            character = claw2.getImage();
        }

        clawAnimationCounter++;
        return character;
    }

    public Image getImage() {

        if (flySwitch == true) {
            character = flyAnimation();
            if (fireSwitch) {
                character = flyfire.getImage();
            }
            return character;
        }

        if (clawSwitch == true) {
            character = clawAnimation();
            if (fireSwitch) {
                character = flyfire.getImage();
            }
            return character;
        } else {
            return character;
        }
    }

    public void KeyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && !flySwitch) {
            if (up != y) {
                if (dx != -defaultspeed) {
                    character = jumpL.getImage();

                }
            }
            if (up == y) {
                if (dx != -defaultspeed) {
                    character = walk1Left.getImage();

                }
            }
            walkAnimationLeft();
            dx = -defaultspeed;
            facingRight = false;
            standSwitch = false;
        }
        if (key == KeyEvent.VK_RIGHT && !flySwitch) {
            if (up != y) {
                if (dx != defaultspeed) {
                    character = jump.getImage();

                }
            }
            if (up == y) {
                if (dx != defaultspeed) {
                    character = walk1.getImage();

                }
            }

            facingRight = true;
            standSwitch = false;
            walkAnimationRight();
            dx = defaultspeed;
        }
        if (key == KeyEvent.VK_UP && !flySwitch) {

            if (up == y) {
                jumpSwitch = true;
                if (facingRight == false) {
                    character = jumpL.getImage();
                    dy = -upSpeed;

                } else {
                    character = jump.getImage();
                    dy = -upSpeed;
                }
                standSwitch = true;
            }

        }

        if (key == KeyEvent.VK_DOWN && !flySwitch) {
            character = stand.getImage();
            dy = defaultspeed;

        }

        if (key == KeyEvent.VK_SPACE && up == y && level == 3) {

            flySwitch = true;

        }

        if (key == KeyEvent.VK_C && up == y && level == 3) {

            flySwitch = false;

        }

        if (key == KeyEvent.VK_UP && flySwitch == true) {

            dy = -defaultspeed;

        }
        if (key == KeyEvent.VK_DOWN && flySwitch == true) {

            dy = defaultspeed;

        }
        if (key == KeyEvent.VK_RIGHT && flySwitch == true) {

            dx = defaultspeed;

        }
        if (key == KeyEvent.VK_LEFT && flySwitch == true) {

            dx = -defaultspeed;

        }

        if (key == KeyEvent.VK_Z && !flySwitch && clawAmmo<=15 && clawAmmo>0 ) {
            clawSwitch = true;
            clawAmmo--;
        }

        if (key == KeyEvent.VK_X && !flySwitch && (level == 2 || level == 3)) {
            fire();
            fireSwitch = true;
            character = fire.getImage();
        }
        if (key == KeyEvent.VK_X && flySwitch && (level == 2 || level == 3)) {
            fire();
            fireSwitch = true;
            character = flyfire.getImage();
        }

    }

    public void KeyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        //character = stand.getImage();

        if (key == KeyEvent.VK_UP && !flySwitch) {

            if (up < y) {
                if (facingRight == false) {
                    character = jumpL.getImage();
                }

                if (facingRight == true) {
                    character = jump.getImage();
                }
            }
        }

        if (key == KeyEvent.VK_LEFT && !flySwitch) {
            dx = 0;
            character = standLeft.getImage();

        }
        if (key == KeyEvent.VK_RIGHT && !flySwitch) {
            dx = 0;
            character = stand.getImage();

        }

        if (key == KeyEvent.VK_DOWN && flySwitch == true) {

            if (up < y) {
                dy = 0;

            }

        }

        if (key == KeyEvent.VK_UP && flySwitch == true) {
            dy = 0;

        }

        if (key == KeyEvent.VK_LEFT && flySwitch) {
            dx = 0;

        }
        if (key == KeyEvent.VK_RIGHT && flySwitch) {
            dx = 0;

        }

        if (key == KeyEvent.VK_Z && !flySwitch) {
            clawSwitch = false;
            character = stand.getImage();
        }

        if (key == KeyEvent.VK_X && !flySwitch) {
            fireSwitch = false;
            character = stand.getImage();

        }

        if (key == KeyEvent.VK_X && flySwitch) {
            fireSwitch = false;
            character = fly2.getImage();

        }

    }

}
