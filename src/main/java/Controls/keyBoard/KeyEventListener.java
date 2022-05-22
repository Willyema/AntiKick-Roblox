package Controls.keyBoard;

import Controls.variables.KeyboardTimeRemaining;
import Controls.variables.MouseTimeRemaining;
import Controls.variables.Paused;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyEventListener {
    Logger l = LogManager.getRootLogger();
    KeyboardTimeRemaining ktm = new KeyboardTimeRemaining();
    MouseTimeRemaining mtm = new MouseTimeRemaining();
    Paused p = new Paused();

    public void RegisterListeners() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new NativeKeyListener() {

                @Override
                public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
                }

                @Override
                public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
                }

                @Override
                public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
                    String keyText = NativeKeyEvent.getKeyText(nativeEvent.getKeyCode());
                    switch (keyText) {
                        case "p":
                        case "P":
                            p.togglePaused();
                            break;
                        case "e":
                        case "E":
                            System.exit(1);
                            break;
                        case "v":
                        case "V":
                            l.info("Mouse time remaining: " + mtm.getTimeRemaining());
                            l.info("Keyboard Time remaining: " + ktm.getTimeRemaining());
                            break;
                    }
                }
            });
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}
