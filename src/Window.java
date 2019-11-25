import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        this.setBounds(100, 100, 1200, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0,0, 1200, 750);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        this.setVisible(true);
    }
}
