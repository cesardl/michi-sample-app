package michi;

import michi.controller.GameController;
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
        GameController controller = GameController.getInstance();

        boolean status = controller.loadSettings();

        if (status) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new JFrameGame().setVisible(true);
                }
            });
        } else {
            System.err.println("Error when loading application");
        }
    }

}
