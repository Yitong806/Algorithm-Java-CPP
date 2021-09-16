import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Thread.sleep(5000);
        Robot r = new Robot();
        Random random = new Random();

        ArrayList<Integer> types = new ArrayList<Integer>();
        for (int i = KeyEvent.VK_0; i <= KeyEvent.VK_9 ; i++) {
            types.add(i);
        }

        for (int i = KeyEvent.VK_A; i<= KeyEvent.VK_Z; i++){
            types.add(i);
        }


        while (true){
            r.mouseMove(872,674);

            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            int length = random.nextInt(99);

            for (int i = 0; i < length; i++) {
                int place = random.nextInt(types.size());
                r.keyPress(types.get(place));
                r.keyRelease(types.get(place));
            }

            r.mouseMove(1084,667);

            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(2000);

        }

    }

    // input: x = 872, y = 674
    // send: x = 1084, y = 667

}