package sandSimulation.window.mouseProcessing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sandSimulation.window.SandWindow;
import sandSimulation.window.pixelHandler.WindowPixels;

import sandSimulation.window.elements.Element;

public class MouseProcessor implements MouseListener {
    private final WindowPixels wp;
    private final int size;

    public MouseProcessor(SandWindow f, Element e, int size, boolean [][] px) {
        this.wp = new WindowPixels(f, e, px);
        this.size = size;
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
        new Thread (() -> {
            System.out.println(e.getX() + ", " + e.getY());
            wp.setPixel(e.getX(), e.getY(), size);
        }).start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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