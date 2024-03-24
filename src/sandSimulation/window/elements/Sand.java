package sandSimulation.window.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.Timer;
import sandSimulation.window.pixelHandler.ColorPxGenerator;

public class Sand extends Element {
    private boolean[][] px;
    private final Dimension d;
    private final Graphics g;
    private Timer timer;

    private final Insets insets;
    private final int limit;

    public Sand(JFrame frame, boolean[][] px) {
        System.out.println("SOY ARENA");
        this.px = px;

        d = frame.getSize();
        g = frame.getGraphics();

        this.insets = frame.getInsets();
        this.limit = d.height - insets.bottom; // Limite de la altura (hotbar de la parte superior de la ventana)
    }

    /**
     * Metodo que siguiendo una logica cambia el array de booleanos
     * para cambiar las posiciones de los pixeles,
     * 
     * Reglas: Ningun pixel puede estar flotando
     */
    @Override
    public void generatePxAnimation() {
        // For aninado que recorre desde el ultimo pixel de todos hasta el primero sin
        // contar los insets
        while (pixelPlaced()) {
            for (int x = d.width - insets.right; x > insets.right; x--) {
                for (int y = d.height; y > insets.top; y--) {
                    // y < limit para que los pixeles se queden abajo
                    if (y < limit && px[x][y - 1] && !px[x][y]) { // Si la posicion anterior en Y esta activada y la
                                                                  // actual
                                                                  // no se pinta la nueva
                        px[x][y - 1] = false;
                        px[x][y] = true;
                        paintPixel(x, y - 1, x, y);
                    } else if (y < limit && !px[x - 1][y] && px[x][y - 1]) { // Si la posicion x - 1 en la altura actual
                                                                             // esta vacia y la altura - 1 en x esta
                                                                             // llena
                                                                             // se mueve
                        px[x][y - 1] = false;
                        px[x - 1][y] = true;
                        paintPixel(x, y - 1, x - 1, y);
                    } else if (y < limit && !px[x + 1][y] && px[x][y - 1]) { // Si la posicion x + 1 en la altura actual
                                                                             // esta vacia y la altura - 1 en x esta
                                                                             // llena
                                                                             // se mueve
                        px[x][y - 1] = false;
                        px[x + 1][y] = true;
                        paintPixel(x, y - 1, x + 1, y);
                    }
                }
            }
        }
    }

    private boolean pixelPlaced() {
        for (int x = d.width - insets.right; x > insets.right; x--) {
            for (int y = d.height - 1; y > insets.top; y--) {
                if (px[x][y] && !px[x][y + 1] && y + 1 < limit) {
                    return true;
                }
            }
        }
        return false;
    }

    private void paintPixel(int xBlack, int yBlack, int xColor, int yColor) {
        g.setColor(Color.BLACK);
        g.drawLine(xBlack, yBlack, xBlack, yBlack);

        g.setColor(new Color(ColorPxGenerator.getRandomColor()));
        g.drawLine(xColor, yColor, xColor, yColor);
    }

    public void stopAnimation() {
        if (timer != null) {
            timer.stop();
        }
    }
}