package sandSimulation.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sandSimulation.window.elements.Element;
import sandSimulation.window.elements.Sand;
import sandSimulation.window.mouseProcessing.MouseProcessor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Scanner;

public class SandWindow extends JFrame {
    private final boolean[][] px;

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

        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño del puntero min 5 max 50: ");
        int mouseSize = sc.nextInt();

        Dimension d = this.getSize();
        px = new boolean[d.width][d.height]; // Array de pixels

        Element e = new Sand(this, px); //Elemento de arena

        addMouseListener(new MouseProcessor(this, e, mouseSize, px));
        sc.close();
    }
}