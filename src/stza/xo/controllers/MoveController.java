package stza.xo.controllers;

import stza.xo.model.*;

public class MoveController {
    /**
     * Устанавливает фигуру на поле.
     *
     * @param field
     * @param point
     * @param figure
     */
    public boolean applyFigure(final Field field, final Point point,final String figure){
        boolean resultOfApply = false;

        if (checkParam(field, point)){
            field.setFigure(point, figure);
            resultOfApply = true;
        }
        return resultOfApply;
    }

    boolean checkParam(final Field field, final Point point){
        int x = point.x;
        int y = point.y;

        if (x < 0 || x > 2 || y < 0 || y > 2){
            return false;
        }

        if (field.getFigure(point) != null){
            return false;
        }
        return true;
    }
}
