package michi;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import michi.controller.GameController;
import michi.view.JFrameGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesar.diaz
 * @see
 * <a href='https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html'>How
 * to Set the Look and Feel</a>
 */
public class App {

    static final Logger log = LoggerFactory.getLogger(App.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager
                    .getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            log.error("Error with class", e);
        } catch (InstantiationException e) {
            log.error("Error while instantiation", e);
        } catch (IllegalAccessException e) {
            log.error("Error illegal access", e);
        } catch (UnsupportedLookAndFeelException e) {
            log.error("Error loading look and feel", e);
        }

        GameController controller = GameController.getInstance();

        boolean status = controller.loadSettings();

        if (status) {
            /* Create and display the form */
            SwingUtilities.invokeLater(new Runnable() {

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
