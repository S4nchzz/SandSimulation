package sandSimulation.window.mouseProcessing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import sandSimulation.window.SandWindow;
import sandSimulation.window.pixelHandler.WindowPixels;

public class MouseProcessor implements MouseListener {
    private JFrame frame;
    private WindowPixels wp;

    private boolean isHolded;

    public MouseProcessor(SandWindow f) {
        this.frame = f;
        wp = new WindowPixels(f);
        isHolded = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Creara un objeto de tipo Thread, cada vez que es invocado
     * se creara un objeto de tipo Thread el cual como parametro
     * creara una instancia de un objeto Runneable e iniciando
     * el codigo que se quiere sobre esta instancia, todo esto
     * en el metodo heredado run
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(e.getX() + ", " + e.getY());

                try {
                    wp.paintPixel(e.getX(), e.getY());
                } catch (InterruptedException ex) {
                    System.out.println(ex.getCause());
                }
            }
        });
        thread.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}