import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {


    final int STEP = 50;
    final int WIDTH = 1200;
    final int HEIGHT = 750;
    final int POINT_SIZE = 8;
    final Color OUTER_POINTS_COLOR = Color.GRAY;
    final Color INNER_POINTS_COLOR = Color.GREEN;

    public Point firstPointOfLine;
    public Point secondPointOfLine;
    private Graphics graphics;
    private Graphics screenGraphics;
    private BufferedImage img;
    private ArrayList<Line> lines;

    private Point[][] points = new Point[WIDTH / STEP][HEIGHT / STEP];

    public Animator(Graphics g) {
        screenGraphics = g;
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        graphics = img.getGraphics();
        init();
    }

    public void init() {
        clearImg();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point(STEP * i, STEP * j);
            }
        }
        lines = new ArrayList<>();
        drawFragmentation();
    }

    public void addLine(Line l) {
        lines.add(l);
    }

    public void drawFragmentation() {

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                Point p = points[i][j];
                setColor(p);
                graphics.fillOval(p.getX() - POINT_SIZE / 2,
                        p.getY() - POINT_SIZE / 2,
                        POINT_SIZE,
                        POINT_SIZE);
            }
        }
    }

    public void setColor(Point p) {
        int position = 1;
        for (Line l : lines) {
            if (l.positionOfPoint(p) < 0) {
                position = -1;
            }
        }
        if (position > 0) {
            graphics.setColor(INNER_POINTS_COLOR);
        } else {
            graphics.setColor(OUTER_POINTS_COLOR);
        }
    }

    public void clearImg() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.BLACK);
    }

    public void drawToScreen() {
        screenGraphics.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
        clearImg();
    }

    public void setFirstPointOfLine(int x, int y) {
        firstPointOfLine = new Point(x, y);
    }

    public void setSecondPointOfLine(int x, int y) {
        secondPointOfLine = new Point(x, y);
        createLine();
    }

    public void createLine() {
        double b = firstPointOfLine.getY() -
                firstPointOfLine.getX() * (secondPointOfLine.getY() - firstPointOfLine.getY()) * 1.0 /
                        (secondPointOfLine.getX() - firstPointOfLine.getX());
        double k = (secondPointOfLine.getY() - firstPointOfLine.getY()) * 1.0 /
                (secondPointOfLine.getX() - firstPointOfLine.getX());
        Line l = new Line(k, b);
        lines.add(l);
        drawLine(l);
        System.out.println(k + "*x + " + b);
    }

    public void drawLine(Line l) {
        graphics.setColor(Color.BLUE);
        graphics.drawLine(10, (int) l.valueOfLine(10), 1200, (int) l.valueOfLine(1200));

    }

    public void drawAll() {
        drawFragmentation();
    }

}
