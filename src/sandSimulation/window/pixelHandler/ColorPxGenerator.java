package sandSimulation.window.pixelHandler;

import java.util.Random;

public class ColorPxGenerator {
    public static int getRandomColor() {
        Random rm = new Random();
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
