package FrontEnd;

import Controls.variables.Paused;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PausedDiag extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel not;
    Paused p = new Paused();

    public PausedDiag() {
        if (p.paused){
            not.setText("Paused");
        } else {
            not.setText("Unpaused");
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        repaint();
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        dispose();
    }
}
