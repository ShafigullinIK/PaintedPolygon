import java.awt.*;
import java.awt.image.BufferedImage;

public class Animator {

    private Graphics graphics;
    private Graphics screenGraphics;
    private BufferedImage img;

    public Animator(Graphics g){
        screenGraphics = g;
        img = new BufferedImage(1200, 750, BufferedImage.TYPE_3BYTE_BGR);
        graphics = img.getGraphics();
    }

    public void drawFragmentation(){

    }

    public void drawToScreen(){
        screenGraphics.drawImage(img, 0, 0, null);
    }

}
