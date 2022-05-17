package Controls.Tasks;

import Controls.Controller;
import Controls.Mouse.Mouse;
import Controls.variables.Paused;

import java.util.TimerTask;

public class MouseTask extends TimerTask {
    Mouse m;
    Paused p = new Paused();

    @Override
    public void run() {
        Controller c = new Controller();
        if (!p.paused) {
            if (c.GenerateMouseClick() == 1) {
                m = new Mouse();
                m.pressMouse(true);
            } else {
                m = new Mouse();
                m.pressMouse(false);
            }
        }
        c.reScheduleMouseClicks();
    }
}
