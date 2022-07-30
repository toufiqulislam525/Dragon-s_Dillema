
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class FireBall {
        int x, y;//-- Controls the CURRENT location of THIS fireball
	 Image img;
	boolean visible;
	//sets weather THIS fireball is visible or not

	int speed=2;
	public int getX()
	{
		return x;
	}

	public boolean getVisible()
	{
		return visible;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return img;
	}
	
        public Rectangle getBounds()
        {
                return new Rectangle(x,y, 96,96);
        }
        
	public FireBall(int startX, int startY)
	{
		ImageIcon newBullet = new ImageIcon("C:\\set1/fireball.png");
		img = newBullet.getImage();
		x = startX;
		y = startY;
		visible = true;
	}
	
	public void move(){
		x = x + speed; //x +fireball speed
		if (x > 1080)// if x > board width
			//Make the fire invisible
			visible = false;
	}
}
    
