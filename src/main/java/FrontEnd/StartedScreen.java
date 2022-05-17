package FrontEnd;

import Controls.Controller;
import Controls.variables.Paused;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class StartedScreen {
    private JButton Quit;
    private JButton pauseButton;
    private JLabel lable;
    private JPanel panel;
    private JFrame f;
    Paused p = new Paused();
    FrontEnd.PausedDiag p2 = new FrontEnd.PausedDiag();

    public void setUpWindow(){
        this.f = new JFrame();
        this.f.add(panel);
        setUpListeners();
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.f.setSize(200, 300);
        this.f.setVisible(true);
    }
    public void setUpListeners(){
        pauseListener();
        quitListener();
    }
    public void pauseListener(){
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.togglePaused();
                p2.pack();
                p2.setVisible(true);
            }
        });
    }
    public void quitListener(){
        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }
}
