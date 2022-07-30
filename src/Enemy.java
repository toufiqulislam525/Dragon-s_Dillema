
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy {

    Image character;
    int x, y, left;
    int defaultspeed = 4;
    boolean isAlive = true;
    int sideSwitch = 0;
    int animationCounter;
    int iniy;
    ImageIcon l1;
    ImageIcon l2;

    public Enemy(int startX, int startY, String location, String location2) {
        x = startX;
        y = startY;
        left = x;
        iniy=startY;
        l1 = new ImageIcon(location);
        l2 = new ImageIcon(location2);
        character = l1.getImage();
        animationCounter = 0;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean Alive() {
        return isAlive;
    }

    public Image getImage() {
        if (animationCounter > 20) {                     //skipping 4 frames for smoothness
            animationCounter = 0;
        }
        if (animationCounter == 0) {
            character = l1.getImage();

        }
        if (animationCounter == 10) {
            character = l2.getImage();
        }

        animationCounter++;
        return character;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 170, 200);

    }

    public void move(int dx, int left) {
        if (dx == defaultspeed && !((left + dx) < 150))//Added this to only move enemy when character moves forward (not back)
        {
            x = x - dx;
        }
        
        if(sideSwitch==0){
           y++;
           if(y==iniy+40){
               sideSwitch=1;
           }
        }
        
        if(sideSwitch==1){
            y--;
            if(y==iniy-40){
                sideSwitch=0;
            }
        }
    }

}
