package Controls.Tasks;

import Controls.variables.Paused;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class AppPausedTask extends TimerTask {
    Logger l = LogManager.getRootLogger();
    Paused p = new Paused();
    @Override
    public void run() {
        l.info("App is paused, aborting reschedule");
        boolean paused = p.paused;
    }
}
