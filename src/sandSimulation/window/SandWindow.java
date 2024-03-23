package sandSimulation.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sandSimulation.window.mouseProcessing.MouseProcessor;

import java.awt.Color;
import java.awt.Image;

public class SandWindow extends JFrame {
    public SandWindow() {
        setTitle("Sand Simulation");
        ImageIcon icon = new ImageIcon("icon.png");
        Image image = icon.getImage();
        
        setIconImage(image);
        setVisible(true);
        setSize(400, 400);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new MouseProcessor(this));
    }
}
