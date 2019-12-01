import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    public Window(){
        this.setBounds(100, 100, 1200, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        Animator animator = new Animator(this.getGraphics());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animator.drawToScreen();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                animator.setFirstPointOfLine(e.getX(), e.getY());

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                animator.setSecondPointOfLine(e.getX(), e.getY());
                animator.drawAll();
                animator.drawToScreen();

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
