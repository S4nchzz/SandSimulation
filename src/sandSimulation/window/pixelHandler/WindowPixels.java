package sandSimulation.window.pixelHandler;

import sandSimulation.window.SandWindow;
import sandSimulation.window.elements.Element;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class WindowPixels {
    private final JFrame frame;
    private Graphics g;
    private final boolean[][] px;
    private final Element e;

    public WindowPixels (SandWindow f, Element e, boolean [][] px) {
        this.frame = f;
        this.px = px;
        this.g = frame.getGraphics();
        this.e = e;
    }

    /**
     * Colocara varios pixeles en la pantalla en forma de circulo con el siguiente codigo
     * @param mouseX Posicion del mouse en X
     * @param mouseY posicion del mouse en Y
     * @param radius Radio del circulo
     * @throws InterruptedException Exception encontrada al generar pixeles
     */
    public void setPixel (int mouseX, int mouseY, int radius) {
        for (int x = 0; x < px.length; x++) {
            for (int y = 0; y < px[x].length; y++) {
                if (Math.pow(x - mouseX, 2) + Math.pow(y - mouseY, 2) <= Math.pow(radius, 2)) {
                    px[x][y] = true;
                    g.setColor(new Color(ColorPxGenerator.getRandomColor()));
                    g.drawLine(x, y, x, y);;
                }
            }
        }
        generatePxAnimation();
    }

    /**
     * Animara la forma en la que caen los pixeles, respetandose unos de otros
     * @throws InterruptedException
     */
    public void generatePxAnimation () {
        e.generatePxAnimation();
    }
}
