package stza.xo.model;

public class Field {

    private final int SIZE_OF_FIELD = 3;

    private String[][] figures = new String[SIZE_OF_FIELD][SIZE_OF_FIELD];

    /**
     * return size of Field
     *
     * @return
     */
    public int getSize() {
        return SIZE_OF_FIELD;
    }

    /**
     * Return figure, which is located in the given coordinate
     * on the field
     *
     * @param point
     * @return
     */
    public String getFigure(Point point) {
        return figures[point.x][point.y];
    }

    /**
     * Sets the figure to a given point.
     *
     * @param point
     * @param figure
     */
    public void setFigure(Point point, String figure) {
        figures[point.x][point.y] = figure;
    }

}
