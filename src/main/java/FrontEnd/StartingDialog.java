package FrontEnd;

import javax.swing.*;

public class StartingDialog extends JDialog {
    private JPanel contentPane;
    private JLabel text;
    private JButton buttonOK;

    public StartingDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public void displayDialog() {
        StartingDialog dialog = new StartingDialog();
        dialog.pack();
        dialog.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StartScreen ss = new StartScreen();
        ss.setUpWindow();
        dispose();
    }
}
