package sandSimulation;

import sandSimulation.window.SandWindow;

import sandSimulation.window.elements.*;

public class Main {
    public static void main(String[] args) {
        Element e = new Sand();
        new SandWindow(e);
    }
}