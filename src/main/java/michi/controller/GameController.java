package michi.controller;

import michi.controller.etc.Sign;

/**
 *
 * @author cesar.diaz
 */
public final class GameController {

    private static final int LENGTH = 3;

    /**
     *
     */
    private Sign[][] matrix;

    /**
     *
     */
    private int moves;

    /**
     *
     */
    public GameController() {
        init();
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
     * @return
     */
    public int getMoves() {
        return moves;
    }

    /**
     *
     * @param x
     * @param y
     * @param sign
     */
    public void markBox(int x, int y, Sign sign) {
        matrix[x][y] = sign;
        moves++;
    }

    /**
     *
     * @param sign
     * @return
     */
    public boolean validate(Sign sign) {
        if (moves < 5) {
            return false;
        }

        for (Sign[] matrix1 : matrix) {
            for (Sign matrix11 : matrix1) {
                System.out.print(matrix11 + "\t");
            }
            System.out.println();
        }
        return false;
    }

}
