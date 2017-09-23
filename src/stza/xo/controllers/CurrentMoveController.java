package stza.xo.controllers;

import stza.xo.model.Field;
import stza.xo.model.Point;

public class CurrentMoveController {

    /**
     * Принимает объект поля и возвращает фигурргу игрока,
     * который сейас ходит. ^_^
     *
     * @param field
     * @return
     */
    public String currentMove(Field field) {
        int size = field.getSize();

        int numberOfX = 0, numberOfO = 0;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                String figure = field.getFigure(new Point(i, j));

                if (figure != null) {

                    switch (figure) {
                        case "X":
                            numberOfX++;
                            break;
                        case "O":
                            numberOfO++;
                            break;
                    }
                }

            }
        }

        String currentPlayer;
        if (numberOfX > numberOfO) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }


        return currentPlayer;
    }
}
