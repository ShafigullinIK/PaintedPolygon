import java.awt.*;
import java.awt.image.BufferedImage;

public class Animator {

    private Graphics graphics;
    private Graphics screenGraphics;
    private BufferedImage img;
    final int STEP = 50;
    final int WIDTH = 1200;
    final int HEIGHT = 750;
    final int POINT_SIZE = 8;

    private Point[][] points = new Point[WIDTH / STEP][HEIGHT / STEP];

    public Animator(Graphics g){
        screenGraphics = g;
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        graphics = img.getGraphics();
        init();
    }

    public void init(){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, WIDTH, HEIGHT);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point(STEP * i, STEP * j);
            }
        }
        drawFragmentation();
    }

    public void drawFragmentation(){
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                Point p = points[i][j];
                graphics.fillOval(p.getX() - POINT_SIZE/2,
                        p.getY() - POINT_SIZE/2,
                        POINT_SIZE,
                        POINT_SIZE);
            }
        }
    }

    public void drawToScreen(){
        screenGraphics.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
    }

}
