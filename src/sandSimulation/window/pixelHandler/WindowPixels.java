package sandSimulation.window.pixelHandler;

import sandSimulation.window.SandWindow;
import sandSimulation.window.elements.Element;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JFrame;

public class WindowPixels {
    private final boolean[][] px;
    private final JFrame frame;
    private Dimension d;
    private Graphics g;
    private final Random rm;

    private final Element e;

    public WindowPixels (SandWindow f, Element e) {
        this.frame = f;
        this.d = frame.getSize();
        this.px = new boolean[d.width][d.height];
        this.g = frame.getGraphics();
        this.e = e;

        rm = new Random();
    }

    /**
     * Colocara varios pixeles en la pantalla en forma de circulo con el siguiente codigo
     * @param mouseX Posicion del mouse en X
     * @param mouseY posicion del mouse en Y
     * @param radius Radio del circulo
     * @throws InterruptedException Exception encontrada al generar pixeles
     */
    public void setPixel (int mouseX, int mouseY, int radius) throws InterruptedException {
        for (int x = 0; x < px.length; x++) {
            for (int y = 0; y < px[x].length; y++) {
                if (Math.pow(x - mouseX, 2) + Math.pow(y - mouseY, 2) <= Math.pow(radius, 2)) {
                    px[x][y] = true;
                    g.setColor(Color.WHITE);
                    g.drawLine(x, y, x, y);;
                }
            }
        }
        generatePxAnimation();
    }

    public void generatePxAnimation() throws InterruptedException {
        Insets insets = frame.getInsets();
        int limit = d.height - insets.bottom; // Limite de la altura (hotbar de la parte superior de la ventana)

        int cPx = (d.height * d.width) - insets.top - insets.bottom; // Cantidad de los pixeles a recorrer en el array a
                                                                     // recorrer
        int goToCpx = 0; // Variable vacia para iniciar la cuenta

        while (true) {
            Thread.sleep(10);
            // For aninado que recorre desde el ultimo pixel de todos hasta el primero sin
            // contar los insets
            for (int x = d.width - insets.right; x > insets.right; x--) {
                for (int y = d.height; y > insets.top; y--) {
                    // y < limit para que los pixeles se queden abajo
                    if (y < limit && px[x][y - 1] && !px[x][y]) { // Si la posicion anterior en Y esta activada y la
                                                                  // actual no se pinta la nueva
                        px[x][y - 1] = false;
                        px[x][y] = true;
                        paintPixel(x, y - 1, x, y);
                    } else if (y < limit && !px[x - 1][y] && px[x][y - 1]) { // Si la posicion x - 1 en la altura actual
                                                                             // esta vacia y la altura - 1 en x esta
                                                                             // llena se mueve
                        px[x][y - 1] = false;
                        px[x - 1][y] = true;
                        paintPixel(x, y - 1, x - 1, y);
                    } else if (y < limit && !px[x + 1][y] && px[x][y - 1]) { // Si la posicion x + 1 en la altura actual
                                                                             // esta vacia y la altura - 1 en x esta
                                                                             // llena se mueve
                        px[x][y - 1] = false;
                        px[x + 1][y] = true;
                        paintPixel(x, y - 1, x + 1, y);
                    }
                }
            }
        }
    }

    private void paintPixel(int xBlack, int yBlack, int xColor, int yColor) {
        g.setColor(Color.BLACK);
        g.drawLine(xBlack, yBlack, xBlack, yBlack);

        g.setColor(new Color(getRandomColor()));
        g.drawLine(xColor, yColor, xColor, yColor);
    }

    private int getRandomColor() {
        switch (rm.nextInt(10)) {
            case 0:
                return 0xFF4500; // OrangeRed
            case 1:
                return 0xFF6347; // Tomato
            case 2:
                return 0xFF7F50; // Coral
            case 3:
                return 0xCD5C5C; // IndianRed
            case 4:
                return 0xFF0000; // Red
            case 5:
                return 0xB22222; // FireBrick
            case 6:
                return 0x8B0000; // DarkRed
            case 7:
                return 0xFFD700; // Gold
            case 8:
                return 0xFFA500; // Orange
            case 9:
                return 0xFF8C00; // DarkOrange
        }
        return 0xFFFF0;
    }
}
