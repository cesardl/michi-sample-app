package michi;

import michi.controller.GameController;
import michi.view.JFrameGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesar.diaz
 */
public class App {

    static final Logger log = LoggerFactory.getLogger(App.class);

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
            log.error("Error when loading application");
        }
    }

}
