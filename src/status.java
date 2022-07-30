
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class status {
    
    int posX,posY;
    public int inX,inY;
    Image healthbarImage,healthbarImagehit1,healthbarImagehit2;
    ImageIcon full= new ImageIcon("C:\\set1/healthbarfull.png");
    ImageIcon hit1= new ImageIcon("C:\\set1/healthbar1hit.png");
    ImageIcon hit2= new ImageIcon("C:\\set1/healthbar2hit.png");
    
    
    public status(){
        
        inX=20;
        posX=inX;
        inY=20;
        posY=inY;
       healthbarImage=full.getImage();
       healthbarImagehit1=hit1.getImage();
       healthbarImagehit2=hit2.getImage();
  
    }
    
    Image getstatusImage(int hit){
        if(hit==1){
            return healthbarImagehit1;
        }
        if(hit==2){
            return healthbarImagehit2;
        }
        else{
            return healthbarImage;
        }
            
        
    }
    
}