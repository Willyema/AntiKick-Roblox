package Controls.variables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MouseTimeRemaining {
    static Logger l = LogManager.getRootLogger();
    public static Long timeRemaining;
    public static void setTimeRemaining(Long timeRemaining1){
        timeRemaining = timeRemaining1;
        l.info("Mouse Time Remaining: "+timeRemaining);
        if (timeRemaining == null){
            l.error("Timeremaining is NULL --> "+ timeRemaining);
        }
    }
    public static Long getTimeRemaining(){
        return timeRemaining;
    }
    public static void subtractTimeRemaining(){
        Runnable removeAsec = new Runnable() {
            public void run() {
                timeRemaining = timeRemaining - 1;
                if (timeRemaining == null){
                    l.error("Timeremaining is NULL --> "+ timeRemaining);
                }
            }
        };


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(removeAsec, 0, 1, TimeUnit.MILLISECONDS);
    }
}