import FrontEnd.StartScreen;
import FrontEnd.StartingDialog;
import Logging.LoggerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        LoggerManager l = new LoggerManager();
        l.createLoggerFolder();
        try {
            l.createProprietiesFile();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
            try {
                System.setProperty("logFolderLocation", System.getProperty("user.home") + "\\AntiKick-Roblox\\Logs");
                System.setProperty("log4j2.configurationFile", System.getProperty("user.home") + "\\AntiKick-Roblox\\Settings\\log4j2.xml");
            } catch (Exception e) {
                int i = 100;
                while (i > 0) {
                    System.out.println("Fuck u nothin works u idiot");
                    i = i - 1;
                }
                e.printStackTrace();
            }
        StartingDialog sd = new StartingDialog();
            sd.displayDialog();
    }
}
