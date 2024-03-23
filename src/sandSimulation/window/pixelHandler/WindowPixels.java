package sandSimulation.window.pixelHandler;

import sandSimulation.window.SandWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;

public class WindowPixels {
    final private boolean [][] pixels;
    final private JFrame frame;
    private Dimension d;

    public WindowPixels (SandWindow f) {
        this.frame = f;

        d = frame.getSize();
        pixels = new boolean[d.width][d.height];
    }

    public void paintPixel (int mouseX, int mouseY) throws InterruptedException{
        Graphics g = frame.getGraphics();
        g.setColor(Color.WHITE);

        g.drawLine(mouseX, mouseY, mouseX, mouseY);
        pixels[mouseX][mouseY] = true;

        update(mouseX, mouseY, g);
    }

    public void update (int mouseX, int mouseY, Graphics g) throws InterruptedException {
        Insets insets = frame.getInsets();
        int limit = d.height - insets.bottom - 1;

        while (mouseY < limit) {
            if (pixels[mouseX][mouseY] && !pixels[mouseX][mouseY + 1]) {
                pixels[mouseX][mouseY] = false;
                pixels[mouseX][mouseY + 1] = true;

                g.setColor(Color.BLACK);
                g.drawLine(mouseX, mouseY, mouseX, mouseY);

                g.setColor(Color.WHITE);
                g.drawLine(mouseX, mouseY + 1, mouseX, mouseY + 1);
            }
            mouseY++;
            Thread.sleep(1);
        }
    }
}
