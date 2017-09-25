package stza.xo.controllers;

import stza.xo.model.Field;
import stza.xo.model.Point;

public class WinnerController {

    /**
     * Возвращает победителя (если имееться).
     *
     * @param field
     * @return
     */
    public String getWinner(final Field field) {
        // Отдельно пилим проверку для Х//
        if ("X".equals(checkLine(field)) ||
                "X".equals(checkColumn(field)) ||
                "X".equals(checkDiagonal1(field)) ||
                "X".equals(checkDiagonal2(field))) {
            return "X";
        }
        //Отдельно пилим проверку для О//
        if (checkLine(field) == "O" ||
                checkColumn(field) == "O" ||
                checkDiagonal1(field) == "O" ||
                checkDiagonal2(field) == "O") {
            return "O";
        }

        return null;
    }

    public String checkLine(final Field field) {//проверяем строки
        for (int x = 0; x < field.getSize(); x++) {
            int counterX = 0;
            int counterO = 0;
            for (int   y = 0; y < field.getSize(); y++) {

                //Запись "field.getFigure(new Point(x, y))" возможна только в
                //том случае, когда в классе Point есть соответствующий конструктор.
                //Конструкторов должно быть два:
                //1) Тот что принимает входящие значения при создании объекта.
                //2) Пустой конструктор. Просто пустой.
                if (field.getFigure(new Point(x, y)) == null) break;//Просто оптимизация. Без этой строчки тоже работает.
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

    public String checkColumn(final Field field) {//проверяем столбики
        for (int y = 0; y < field.getSize(); y++) {
            int counterX = 0;
            int counterO = 0;
            for (int x = 0; x < field.getSize(); x++) {
                if (field.getFigure(new Point(x, y)) == null) break;//Просто оптимизация. Без этой строчки тоже работает.
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

    public String checkDiagonal1(final Field field) {
        int counterX = 0;
        int counterO = 0;
        for (int y = 0 ; y < field.getSize(); y++)  {
            if (field.getFigure(new Point(y, y)) == null) break;//Просто оптимизация. Без этой строчки тоже работает.
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

    public String checkDiagonal2(final Field field) {
        int counterX = 0;
        int counterO = 0;
        for (int y = 0; y < field.getSize(); y++) {
            int x = field.getSize() - y - 1;
            if (field.getFigure(new Point(x, y)) == null) break; //Просто оптимизация. Без этой строчки тоже работает.
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
