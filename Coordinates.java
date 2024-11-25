package cloneSim;

import cloneSim.board.Board;

import java.util.Objects;

public record Coordinates(Integer row, Integer column) {

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(this.row + shift.rowShift, this.column + shift.columnShift);
    }

    public boolean canShift(CoordinatesShift shift, Board board) {
        int r = row + shift.rowShift;
        int c = column + shift.columnShift;
        if ((r < 0) || (r >= board.getHeight())) return false;
        return (c >= 0) && (c < board.getWidth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(row, that.row) && Objects.equals(column, that.column);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                row + "," + column +
                '}';
    }
}
