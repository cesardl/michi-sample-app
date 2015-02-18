package michi;

import michi.view.JFrameGame;

/**
 *
 * @author cesar.diaz
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JFrameGame().setVisible(true);
            }
        });
    }

}
