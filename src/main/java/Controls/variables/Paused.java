package Controls.variables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paused {
    static Logger l = LogManager.getRootLogger();
    public static boolean paused = false;
    private static void setPaused(Boolean Cpaused){
        paused = Cpaused;
    }
    public static void togglePaused(){
        if (paused){
            paused = false;
        } else {
            paused = true;
        }
        l.info("Toggled paused, now its "+paused);
    }
}
