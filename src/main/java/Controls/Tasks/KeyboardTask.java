package Controls.Tasks;

import Controls.Controller;
import Controls.variables.Paused;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.Random;
import java.util.TimerTask;

import static java.awt.event.KeyEvent.*;

public class KeyboardTask extends TimerTask {
    Logger l = LogManager.getRootLogger();
    Paused p = new Paused();

    @Override
    public void run() {
        if (!p.paused){
        Random r = new Random();
        int toWrite = 0;
        int rand = r.nextInt(6);
        l.debug("Number Chosen (Keyboard) = " + rand);
        if (rand == 1){
            toWrite = VK_W;
        } else if (rand == 2){
            toWrite = VK_A;
        } else if (rand == 3) {
            toWrite = VK_S;
        } else if (rand == 4){
            toWrite = VK_D;
        } else if (rand == 5) {
            toWrite = VK_SPACE;
        }
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (toWrite != 0) {
            bot.keyPress(toWrite);
            try {
                Thread.sleep(r.nextInt(101));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bot.keyRelease(toWrite);
        }
        l.debug("Tried to type = " + toWrite);
    }
        Controller c = new Controller();
        c.reScheduleKeyPress();
    }
}
