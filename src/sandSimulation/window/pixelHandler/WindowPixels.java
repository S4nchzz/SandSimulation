package sandSimulation.window.pixelHandler;

import sandSimulation.window.SandWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Paint;

import javax.swing.JFrame;

public class WindowPixels {
    final private boolean [][] px;
    final private boolean [][] nGen;
    final private JFrame frame;
    private Dimension d;

    private Graphics g;

    public WindowPixels (SandWindow f) {
        this.frame = f;

        d = frame.getSize();
        px = new boolean[d.width][d.height];
        nGen = px;

        g = frame.getGraphics();
    }

    public void setPixel (int mouseX, int mouseY) throws InterruptedException{
        px[mouseX][mouseY] = true;
        generateNextGen(mouseX, mouseY);
    }

    public void generateNextGen (int mouseX, int mouseY) throws InterruptedException {
        Insets insets = frame.getInsets();
        for (int x = 0; x < px.length; x++) {
            for (int y = 0; y < px[x].length - insets.bottom; y++) {
                if (px[x][y] && !px[x][y + 1]) {
                    px[x][y] = false;
                    px[x][y + 1] = true;
                    paintPixel(x, y);
                    Thread.sleep(1);
                } else if (px[x][y] && !px[x - 1][y + 1]) {
                    px[x][y] = false;
                    px[x - 1][y + 1] = true;
                    paintPixel(x, y);
                    Thread.sleep(1);
                } else if (px[x][y] && !px[x + 1][y + 1]) {
                    px[x][y] = false;
                    px[x + 1][y + 1] = true;
                    paintPixel(x, y);
                    Thread.sleep(1);
                }
            }
        }
    }

    private void paintPixel(int x, int y) {
        Graphics g = frame.getGraphics();
        g.setColor(Color.BLACK);
        g.drawLine(x, y - 1, x, y - 1);

        g.setColor(Color.WHITE);
        g.drawLine(x, y, x, y);
    }
}
