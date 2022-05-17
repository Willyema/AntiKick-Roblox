package Controls;

import Controls.Tasks.AppPausedTask;
import Controls.Tasks.KeyboardTask;
import Controls.Tasks.MouseTask;
import Controls.variables.KeyboardTimeRemaining;
import Controls.variables.MouseTimeRemaining;
import Controls.variables.Paused;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Timer;

public class Controller {
    Logger l = LogManager.getRootLogger();
    Paused p = new Paused();
    KeyboardTimeRemaining ktm = new KeyboardTimeRemaining();
    MouseTimeRemaining mtm = new MouseTimeRemaining();
    Timer t = new Timer();

    public void StartProgram(){
        Long mouseDelay = GenerateDelay();
        l.debug("mouseDelay --> "+ mouseDelay);
        mtm.setTimeRemaining(mouseDelay);
        Long keyDelay = GenerateDelay();
        l.debug("keyDelay --> "+ keyDelay);
        ktm.setTimeRemaining(keyDelay);
       // t.schedule(new MouseTask(), mouseDelay);
        t.schedule(new KeyboardTask(), keyDelay);
        l.info("Scheduled tasks");
    }
    public void reScheduleMouseClicks(){
        if (!p.paused) {
            MouseTimeRemaining mtm = new MouseTimeRemaining();
            Long mouseDelay = GenerateDelay();
            mtm.setTimeRemaining(mouseDelay);
            t.schedule(new MouseTask(), mouseDelay);
            l.info("Rescheduled mouse clicks");
            l.debug("mouseDelay --> "+ mouseDelay);
        }
    }
    public void reScheduleKeyPress(){
        if (!p.paused) {
            KeyboardTimeRemaining ktm = new KeyboardTimeRemaining();
            Long keyDelay = GenerateDelay();
            ktm.setTimeRemaining(keyDelay);
            t.schedule(new KeyboardTask(), keyDelay);
            l.info("Rescheduled keyboard clicks");
            l.debug("keyDelay --> "+ keyDelay);
        }
    }
    public Long GenerateMouseClick(){
        Random r = new Random();
        Long chosenValue = new Long(0);
        if (r.nextBoolean() == true){
            chosenValue = Long.valueOf(1);
        } else {
            chosenValue = Long.valueOf(2);
        }
        l.info("Chosen mouse click: "+ chosenValue);
        return chosenValue;
    }
    public Long GenerateDelay(){
        Random r = new Random();
        Long chosenValue = r.longs(1, 100, 10000).toArray()[0];
        return chosenValue;
    }
}