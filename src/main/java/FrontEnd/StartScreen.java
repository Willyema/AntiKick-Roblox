package FrontEnd;

import Controls.Controller;
import Controls.keyBoard.KeyEventListener;
import Controls.variables.KeyboardTimeRemaining;
import Controls.variables.MouseTimeRemaining;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen {
    private JPanel Panel;
    private JButton startButton;
    private JLabel label;
    private JFrame f;
    Logger l = LogManager.getRootLogger();
    KeyboardTimeRemaining ktr = new KeyboardTimeRemaining();
    MouseTimeRemaining mtr = new MouseTimeRemaining();

    public void setUpWindow(){
        this.f = new JFrame();
        this.f.add(Panel);
        setUpListeners();
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.f.setSize(300, 300);
        this.f.setVisible(true);
    }
    public void setUpListeners(){
        startListener();
    }
    public void startListener(){
        l.info("Started StartListener - StartScreen");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller c = new Controller();
                KeyEventListener kel = new KeyEventListener();
                c.StartProgram();
                kel.RegisterListeners();
                StartedScreen ss = new StartedScreen();
                ss.setUpWindow();
                f.setVisible(false);
                ktr.subtractTimeRemaining();
                mtr.subtractTimeRemaining();
            }
        });
    }
}
