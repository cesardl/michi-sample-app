package michi.controller;

import michi.model.Settings;
import michi.model.etc.Status;
import michi.model.etc.Sign;

/**
 *
 * @author cesar.diaz
 */
public final class GameController {

    private static GameController INSTANCE = null;

    private static final int LENGTH = 3;

    /**
     *
     */
    private Settings settings;
    /**
     *
     */
    private Sign[][] matrix;
    /**
     *
     */
    private Sign currentPlayer;
    /**
     *
     */
    private int moves;

    /**
     *
     */
    private GameController() {
        init();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameController();
        }
    }

    public static GameController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /**
     *
     */
    public void init() {
        matrix = new Sign[LENGTH][LENGTH];
        moves = 0;
    }

    /**
     *
     */
    public void restart() {
        if (settings == null) {
            throw new IllegalStateException("Can't restart application if settings aren't loaded");
        }
        init();
        currentPlayer = settings.getFirstPlayer();
    }

    public Sign getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     *
     * @return
     */
    public int getMoves() {
        return moves;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void markBox(int x, int y) {
        matrix[x][y] = currentPlayer;
        moves++;

        // Change player
        if (Sign.X.equals(currentPlayer)) {
            currentPlayer = Sign.O;
        } else {
            currentPlayer = Sign.X;
        }

        validate();
    }

    /**
     *
     * @return
     */
    private Status validate() {
        if (moves < 5) {
            return Status.PLAYING;
        }
        System.out.println("==================");

        for (Sign[] matrix1 : matrix) {
            for (Sign matrix11 : matrix1) {
                System.out.print(matrix11 + "\t");
            }
            System.out.println();
        }

        return Status.POSSIBLE_WINNER;
    }

    private boolean ganador() {
        boolean b = false;
//        if (counter >= 3) {
        for (int i = 0; i < matrix.length && !b; i++) {
            if (matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2])) {
                b = true;
//                    v = 1;
//                    s = matrix[i][0];
            }
            if (matrix[0][i].equals(matrix[1][i]) && matrix[1][i].equals(matrix[2][i])) {
                b = true;
//                    v = 1;
//                    s = matrix[0][i];
            }
            if (i == 0) {
                if (matrix[i][i].equals(matrix[i + 1][i + 1]) && matrix[i + 1][i + 1].equals(matrix[i + 2][i + 2])) {
                    b = true;
//                        v = 1;
//                        s = matrix[i][i];
                }
            } else if (i == 2) {
                if (matrix[0][i].equals(matrix[i - 1][i - 1]) && matrix[i - 1][i - 1].equals(matrix[i][0])) {
                    b = true;
//                        v = 1;
//                        s = matrix[i][i];
                }
            }
        }
//        }
        return b;
    }

    /**
     *
     * @return
     */
    public boolean loadSettings() {
        //TODO Load settings from DB
        settings = new Settings();
        //FIXME set from DB os settings
        settings.setFirstPlayer(Sign.X);

        // Set values for default launch
        currentPlayer = settings.getFirstPlayer();

        return true;
    }

}
