package sandSimulation.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sandSimulation.window.elements.Element;

import sandSimulation.window.mouseProcessing.MouseProcessor;

import java.awt.Color;
import java.awt.Image;
import java.util.Scanner;

public class SandWindow extends JFrame {
    public SandWindow(Element e) {
        setTitle("Sand Simulation");
        ImageIcon icon = new ImageIcon("icon.png");
        Image image = icon.getImage();
        
        setIconImage(image);
        setVisible(true);
        setSize(1000, 1000);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño del puntero min 5 max 50: ");
        addMouseListener(new MouseProcessor(this, e, sc.nextInt()));
        sc.close();
    }
}