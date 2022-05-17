package Controls.Mouse;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.InputEvent;

public class Mouse {
    private Robot bot;
    {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public void pressMouse(@NotNull Boolean switchb){
        int mask;
        if (switchb){
            mask = InputEvent.BUTTON1_DOWN_MASK;
        } else {
            mask = InputEvent.BUTTON2_DOWN_MASK;
        }
        bot.mousePress(mask);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bot.mouseRelease(mask);
    }
    public void moveMouse(int pos1, int pos2){
        bot.mouseMove(pos1, pos2);
    }
}
