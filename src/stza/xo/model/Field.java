package stza.xo.model;

public class Field {

    private final int SIZE_OF_FIELD = 3;

    private String[][] figures = new String[SIZE_OF_FIELD][SIZE_OF_FIELD];


    public int getSize() {
        return SIZE_OF_FIELD;
    }


    public String getFigure(Point point) {
        return figures[point.x][point.y];
    }


    public void setFigure(Point point, String figure) {
        figures[point.x][point.y] = figure;
    }

}
