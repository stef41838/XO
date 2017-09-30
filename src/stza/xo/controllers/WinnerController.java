package stza.xo.controllers;

import stza.xo.model.Field;
import stza.xo.model.Point;

public class WinnerController {


    public String getWinner(final Field field) {

        if ("X".equals(checkLine(field)) ||
                "X".equals(checkColumn(field)) ||
                "X".equals(checkDiagonal1(field)) ||
                "X".equals(checkDiagonal2(field))) {
            return "X";
        }

        if (checkLine(field) == "O" ||
                checkColumn(field) == "O" ||
                checkDiagonal1(field) == "O" ||
                checkDiagonal2(field) == "O") {
            return "O";
        }

        return null;
    }

    private String checkLine(final Field field) {//проверяем строки
        for (int x = 0; x < field.getSize(); x++) {
            int counterX = 0;
            int counterO = 0;
            for (int y = 0; y < field.getSize(); y++) {


                if (field.getFigure(new Point(x, y)) == null) break;
                if ("X".equals(field.getFigure(new Point(x, y)))) {
                    counterX++;
                } else {
                    counterO++;
                }
            }
            if (counterX == field.getSize()) return "X";
            if (counterO == field.getSize()) return "O";
        }

        return null;
    }

    private String checkColumn(final Field field) {//проверяем столбики
        for (int y = 0; y < field.getSize(); y++) {
            int counterX = 0;
            int counterO = 0;
            for (int x = 0; x < field.getSize(); x++) {
                if (field.getFigure(new Point(x, y)) == null)
                    break;//Просто оптимизация. Без этой строчки тоже работает.
                if ("X".equals(field.getFigure(new Point(x, y)))) {
                    counterX++;
                } else {
                    counterO++;
                }
            }
            if (counterX == field.getSize()) return "X";
            if (counterO == field.getSize()) return "O";
        }
        return null;
    }

    private String checkDiagonal1(final Field field) {
        int counterX = 0;
        int counterO = 0;
        for (int y = 0; y < field.getSize(); y++) {
            if (field.getFigure(new Point(y, y)) == null) break;
            if (field.getFigure(new Point(y, y)) == "X") {
                counterX++;
            } else {
                counterO++;
            }
        }

        if (counterX == field.getSize()) return "X";
        if (counterO == field.getSize()) return "O";
        return null;
    }

    private String checkDiagonal2(final Field field) {
        int counterX = 0;
        int counterO = 0;
        for (int y = 0; y < field.getSize(); y++) {
            int x = field.getSize() - y - 1;
            if (field.getFigure(new Point(x, y)) == null) break;
            if (field.getFigure(new Point(x, y)) == "X") {
                counterX++;
            } else {
                counterO++;

            }
        }

        if (counterX == field.getSize()) return "X";
        if (counterO == field.getSize()) return "O";
        return null;
    }
}
